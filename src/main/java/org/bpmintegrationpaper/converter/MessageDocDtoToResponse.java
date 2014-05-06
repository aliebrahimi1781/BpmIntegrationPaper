package org.bpmintegrationpaper.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.bpmintegrationpaper.dto.SendResponseDto;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
@Converter
public final class MessageDocDtoToResponse {

    /**
     * 
     * Constructor.
     */
    private MessageDocDtoToResponse() {
    }

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(MessageDocDtoToResponse.class);

    /**
     * A converter.
     * 
     * @param dto
     *            To convert.
     * @param exc
     *            .
     * @return byte[].
     */
    @Converter
    public static SendResponseDto toResponse(final DocumentBpmDto dto,
            final Exchange exc) {
        LOG.error("Converter: Dto:" + dto);
        final SendResponseDto response = new SendResponseDto();
        response.setCode(0);
        return response;
    }
}
