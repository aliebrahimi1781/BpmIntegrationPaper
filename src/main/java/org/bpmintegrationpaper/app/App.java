package org.bpmintegrationpaper.app;

import org.apache.camel.main.Main;
import org.bpmintegrationpaper.input.soap.SoapInput;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 18/04/2014
 */
public final class App  {

    /**
     * Constructor.
     */
    private App() {
    }

    /**
     * Start class to execute stand alone aplication.
     * 
     * @param args
     *            Main Args.
     * @throws Exception
     *             puts.
     */
    public static void main(final String[] args) throws Exception {
        final Main main = new Main();
        main.addRouteBuilder(new SoapInput());
        System.out.println("Starting Camel."
                + "\nUse ctrl + c to terminate the JVM.\n");
        main.run();
    }
}
