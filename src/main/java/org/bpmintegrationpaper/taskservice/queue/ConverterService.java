package org.bpmintegrationpaper.taskservice.queue;

import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 05/05/2014
 */
public class ConverterService extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {

	from(mekeQueue("converter.send"))
	.convertBodyTo(DocumentBpmDto.class)
		.to("activiti:ReceiveDocumentProcess:receiveFromConvert"
		+ "?copyVariablesToProperties=true"
		+ "&copyVariablesToBodyAsMap=true");
    }

}
