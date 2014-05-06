package org.bpmintegrationpaper.taskservice.translator;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 05/05/2014
 */
public class JsonToXmlService extends AbstractRouteBuilder {

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(JsonToXmlService.class);

    @Override
    public final void configure() throws Exception {
        from(mekeQueue("bpm.send")).process(new Processor() {

            @Override
            public void process(final Exchange exc) throws Exception {
                LOG.error("BPM Input: In " + exc.getIn().getBody());
                LOG.error("BPM Input: Header " + exc.getIn().getHeaders());
                LOG.error("BPM Input: Propeties " + exc.getProperties());
            }
        }).to("activiti:ReceiveDocumentProcess");
    }
}