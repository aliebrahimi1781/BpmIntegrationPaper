package org.bpmintegrationpaper.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.bpmintegrationpaper.dto.DocumentBpmDto;

import com.google.gson.Gson;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
@Converter
public final class BytesToDocumentBpmDto {

    /**
     * 
     * Constructor.
     */
    private BytesToDocumentBpmDto() {
    }


    /**
     * A converter.
     * 
     * @param bytes
     *            . To convert.
     * @param exc
     *            .
     * @return dto.
     */
    @Converter
    public static DocumentBpmDto toInputStream(final byte[] bytes,
            final Exchange exc) {
        final String json = new String(bytes);
        final DocumentBpmDto dto = new Gson().fromJson(json,
                DocumentBpmDto.class);

        return dto;
    }
}
