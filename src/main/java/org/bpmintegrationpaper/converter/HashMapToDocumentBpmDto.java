package org.bpmintegrationpaper.converter;

import java.util.HashMap;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 05/05/2014
 */
@Converter
public final class HashMapToDocumentBpmDto {

    /**
     * 
     * Constructor.
     */
    private HashMapToDocumentBpmDto() {
    }

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(HashMapToDocumentBpmDto.class);

    /**
     * A converter.
     * 
     * @param hashMap
     *            To convert.
     * @param exc
     *            .
     * @return DocumentBpmDto.
     */
    @Converter
    public static DocumentBpmDto toInputStream(
            final HashMap<String, Object> hashMap,
            final Exchange exc) {
        LOG.error("Converter: HashMap:" + hashMap);
        final DocumentBpmDto doc = new DocumentBpmDto(hashMap);
        return doc;
    }
}
