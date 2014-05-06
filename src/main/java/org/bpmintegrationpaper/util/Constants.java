package org.bpmintegrationpaper.util;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 22/04/2014
 */
public final class Constants {

    /**
     * Constructor.
     */
    private Constants() {

    }

    /**
     * Path to new files.
     */
    public static final String FILE_PATH
    = "c:/tmp/bpmintegrationpaper/in/document/";

    /**
     * Number of threads.
     */
    public static final Integer RABBIT_THREAD_POOL = 1;

    /**
     * User.
     */
    public static final String RABBIT_USER = "guest";

    /**
     * Password.
     */
    public static final String RABBIT_PASS = "guest";

    /**
     * RabbitMQ Port.
     */
    public static final Integer RABBIT_PORT = 5672;

    /**
     * Rabbit Ip.
     */
    public static final String RABBIT_IP = "127.0.0.1";
}
