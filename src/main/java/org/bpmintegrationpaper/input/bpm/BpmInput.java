package org.bpmintegrationpaper.input.bpm;

import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 28/04/2014
 */
public class BpmInput extends AbstractRouteBuilder {

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(BpmInput.class);

    @Override
    public final void configure() throws Exception {
        from(mekeQueue("bpm.send"))
        .convertBodyTo(DocumentBpmDto.class)
        .to("activiti:ReceiveDocumentProcess?copyVariablesToBodyAsMap=true&copyCamelBodyToBody=true&copyVariablesToProperties=true")
        .log("${body}");
    }
}
