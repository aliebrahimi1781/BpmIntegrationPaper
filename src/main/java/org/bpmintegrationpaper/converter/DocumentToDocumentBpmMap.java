package org.bpmintegrationpaper.converter;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.bpmintegrationpaper.dto.DocumentDto;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
@Converter
public final class DocumentToDocumentBpmMap {

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(DocumentToDocumentBpmMap.class);

    /**
     * Constructor.
     */
    private DocumentToDocumentBpmMap() {
    }

    /**
     * Convert.
     * 
     * @param document
     *            .
     * @param exc
     *            .
     * @return DocumentBpmDto.
     */
    @Converter
    public static DocumentBpmDto convert(final DocumentDto document,
            final Exchange exc) {
        final DocumentBpmDto dto = new DocumentBpmDto();
        dto.setFilePath(exc.getIn().getHeader("CamelFileNameProduced"));
        dto.setDocType("" + document.getDocType());
        dto.setFormat(document.getFormat());
        dto.setNote(document.getNote());
        dto.setPassword(document.getPassword());
        dto.setUser(document.getUser());
        return dto;
    }
}
