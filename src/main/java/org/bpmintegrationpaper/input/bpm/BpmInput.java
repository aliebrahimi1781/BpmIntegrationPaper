package org.bpmintegrationpaper.input.bpm;

import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.bpmintegrationpaper.dto.DocumentBpmDto;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 28/04/2014
 */
public class BpmInput extends AbstractRouteBuilder {
    @Override
    public final void configure() throws Exception {
	from(mekeQueue("bpm.send")).id("BpmInput")
	.convertBodyTo(DocumentBpmDto.class)
		.to("activiti:ReceiveDocumentProcess?"
			+ "copyVariablesToBodyAsMap=true"
			+ "&copyCamelBodyToBody=true"
			+ "&copyVariablesToProperties=true")
		.log("${body}");
    }
}
