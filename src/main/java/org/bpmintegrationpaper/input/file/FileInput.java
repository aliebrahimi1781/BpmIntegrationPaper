/**
 * FileService.
 * @author Ramon
 */
package org.bpmintegrationpaper.input.file;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * A simple route to get files.
 * 
 * @version
 */
public class FileInput extends RouteBuilder {

    @Override
    public final void configure() {
        from("file:///tmp/bpmintegrationpaper/in/")
.id("FileInput")
        .process(
                new Processor() {

                    @Override
                    public void process(final Exchange exc) throws Exception {
                        final Map<String, Object> map
                        = new HashMap<String, Object>(2);
                        final String
                        file = (String) exc.getIn().getHeader("CamelFileName");
                        map.put("file", file);
                        map.put("from", "Teste");
                        exc.getOut().setBody(map);
                    }
                }).to("activiti:ReceiveDocumentProcess").log("End of process");
    }

}
