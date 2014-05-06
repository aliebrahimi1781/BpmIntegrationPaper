package org.bpmintegrationpaper.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 19/04/2014
 */
public final class IOUtils {

    /**
     * Constructor.
     */
    private IOUtils() {
    }

    /**
     * Close easy.
     * 
     * @param closable
     *            Object to close.
     */
    public static void closeQuietly(final Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (final IOException e) {
                // Do nothing
                return;
            }
        }
    }
}
