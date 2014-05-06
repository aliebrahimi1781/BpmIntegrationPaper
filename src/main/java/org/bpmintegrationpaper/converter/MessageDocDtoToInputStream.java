package org.bpmintegrationpaper.converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;
import org.bpmintegrationpaper.dto.DocumentDto;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
@Converter
public final class MessageDocDtoToInputStream {

    /**
     * 
     * Constructor.
     */
    private MessageDocDtoToInputStream() {
    }

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(MessageDocDtoToInputStream.class);

    /**
     * A converter.
     * 
     * @param message
     *            To convert.
     * @param exc
     *            .
     * @return InputStream.
     */
    @Converter
    public static InputStream toInputStream(final MessageContentsList message,
            final Exchange exc) {
        LOG.error("Converter: Message:" + message);
        ByteArrayInputStream input = null;
        if (message.size() == 1 && message.get(0) instanceof DocumentDto) {
            final DocumentDto dto = (DocumentDto) message.get(0);
            input = new ByteArrayInputStream(dto.getContent());
            exc.getOut().setHeader("document", dto);
            exc.setProperty("document", dto);
        } else {
            LOG.error("Can't convert MessageContentsList, "
                    + "because it isn't DocumentDto instanceOf "
                    + "or list isn't equal 1. "
                    + "MessageContentLinst: " + message);
        }
        return input;
    }
}
