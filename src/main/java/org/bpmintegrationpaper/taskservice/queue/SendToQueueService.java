package org.bpmintegrationpaper.taskservice.queue;

import org.bpmintegrationpaper.api.AbstractRouteBuilder;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 05/05/2014
 */
public class SendToQueueService extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {
	from(
		"activiti:ReceiveDocumentProcess:convertFromJson"
			+ "?copyVariablesToProperties=true"
			+ "&copyVariablesToBodyAsMap=true")
			.log("${body}");
    }

}
