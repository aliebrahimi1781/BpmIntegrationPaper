package org.bpmintegrationpaper.input.soap;

import javax.jws.WebParam;

import org.bpmintegrationpaper.dto.DocumentDto;
import org.bpmintegrationpaper.dto.SendResponseDto;


/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 16/04/2014
 */
public class SendService {

    /**
     * Send a document.
     * 
     * @param document
     *            A document to send.
     * @return Response code equal zero all right, else fail.
     */
    public SendResponseDto send(
            @WebParam(name = "document") final DocumentDto document) {
        return null;
    };
}
