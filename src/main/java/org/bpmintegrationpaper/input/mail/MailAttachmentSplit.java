package org.bpmintegrationpaper.input.mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.support.ExpressionAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.util.BASE64DecoderStream;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 19/04/2014
 */
public class MailAttachmentSplit extends ExpressionAdapter {

    private static final Logger LOG = LoggerFactory
            .getLogger(MailAttachmentSplit.class);

    @Override
    public Object evaluate(final Exchange exchange) {
        // must use getAttachments to ensure attachments is initial populated
        if (exchange.getIn().getAttachments().isEmpty()) {
            return null;
        }

        // we want to provide a list of messages with 1 attachment per mail
        final List<Message> answer = new ArrayList<Message>();

        for (final Map.Entry<String, DataHandler> entry : exchange.getIn()
                .getAttachments().entrySet()) {
            final Message copy = exchange.getIn().copy();
            copy.getAttachments().clear();
            copy.getAttachments().put(entry.getKey(), entry.getValue());
            LOG.error("Attachment object: " + entry.getValue());
            try {
                if (entry.getValue().getContent() 
                        instanceof BASE64DecoderStream) {
                    BASE64DecoderStream part = null;
                    part = (BASE64DecoderStream) entry.getValue().getContent();
                    copy.setBody(part);
                } else if (entry.getValue().getContent() 
                        instanceof MimeBodyPart) {
                    MimeBodyPart part = null;
                    part = (MimeBodyPart) entry.getValue().getContent();
                    copy.setBody(part.getInputStream());
                } else {
                    LOG.error("Can't define attachment content.");
                }

            } catch (final IOException e) {
                LOG.error("Can't convert attachment", e);
            } catch (final MessagingException e) {
                LOG.error("Can't set the new body.", e);
            }
            answer.add(copy);
        }

        return answer;
    }
}