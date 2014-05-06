package org.bpmintegrationpaper.api;

import org.bpmintegrationpaper.util.Constants;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 02/05/2014
 */
public abstract class AbstractRouteBuilder extends
org.apache.camel.builder.RouteBuilder {


    /**
     * Make one queue.
     * 
     * @param queue
     *            Queue Name.
     * @return Queue.
     */
    public String mekeQueue(final String queue) {
        return "rabbitmq://" + Constants.RABBIT_IP + ":" + Constants.RABBIT_PORT
                + "/" + queue + "?routingKey=" + queue + "&queue=" + queue
                + "&exchangeType=direct" + "&vhost=ramonrs&durable=true"
                + "&autoDelete=false&autoAck=false" + "&threadPoolSize="
                + Constants.RABBIT_THREAD_POOL + "&username="
                + Constants.RABBIT_USER + "&password=" + Constants.RABBIT_PASS;
    }
}
