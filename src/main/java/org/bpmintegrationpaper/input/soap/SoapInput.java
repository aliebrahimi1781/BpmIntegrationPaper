package org.bpmintegrationpaper.input.soap;

import java.io.InputStream;

import org.bpmintegrationpaper.api.AbstractRouteBuilder;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.bpmintegrationpaper.dto.SendResponseDto;
import org.bpmintegrationpaper.util.Constants;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 16/04/2014
 */
public class SoapInput extends AbstractRouteBuilder {

    @Override
    public final void configure() throws Exception {
        from("cxf:http://localhost:80/soap/send?"
                + "serviceClass=org.bpmintegrationpaper.input.soap.SendService"
                + "&dataFormat=POJO")
                .id("SoapInput")
                .convertBodyTo(InputStream.class)
                .to("file://" + Constants.FILE_PATH)
                .setBody(header("document"))
                .convertBodyTo(DocumentBpmDto.class)
                .to(mekeQueue("bpm.send"))
                .convertBodyTo(SendResponseDto.class)
                .log("body: ${body}");
    }
}
