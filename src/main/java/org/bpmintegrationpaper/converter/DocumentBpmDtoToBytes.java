package org.bpmintegrationpaper.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
@Converter
public final class DocumentBpmDtoToBytes {

    /**
     * 
     * Constructor.
     */
    private DocumentBpmDtoToBytes() {
    }

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(DocumentBpmDtoToBytes.class);

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
    public static byte[] toInputStream(final DocumentBpmDto dto,
            final Exchange exc) {
        LOG.error("Converter: Dto:" + dto);
        final String json = new Gson().toJson(dto);
        final byte[] bytes = json.getBytes();
        return bytes;
    }
}
