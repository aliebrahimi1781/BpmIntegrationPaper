package org.bpmintegrationpaper.taskservice.queue;

import org.apache.camel.LoggingLevel;
import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.bpmintegrationpaper.dto.DocumentBpmDto;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 05/05/2014
 */
public class SendToConverterQueueService extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {
	from(
		"activiti:ReceiveDocumentProcess:sendToConvert"
			+ "?copyVariablesToProperties=true"
			+ "&copyVariablesToBodyAsMap=true")
	.convertBodyTo(DocumentBpmDto.class)
	.log(LoggingLevel.ERROR, "File converted!!!")
	.to(mekeQueue("converter.send"));
    }

}
