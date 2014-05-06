package org.bpmintegrationpaper.input.mail;

import org.apache.camel.builder.RouteBuilder;
import org.bpmintegrationpaper.util.ActivitiMessageHelper;
import org.bpmintegrationpaper.util.Constants;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 18/04/2014
 */
public class MailInput extends RouteBuilder {

    private static final
    ActivitiMessageHelper HELPER = new ActivitiMessageHelper();
    private static final
    MailAttachmentSplit SPLITTER = new MailAttachmentSplit();

    @SuppressWarnings("deprecation")
    @Override
    public void configure() throws Exception {
        from(
                "imaps://imap.gmail.com?"
                        + "consumer.delay=6000&"
                        + "username=username&"
                        + "password=secret&"
                        + "mapMailMessage=true")
                        .id("MailInput")
                        .split(SPLITTER)
                .to("file://" + Constants.FILE_PATH)
                        .setBody(bean(HELPER))
                        .to("activiti:ReceiveDocumentProcess");
    }
}
