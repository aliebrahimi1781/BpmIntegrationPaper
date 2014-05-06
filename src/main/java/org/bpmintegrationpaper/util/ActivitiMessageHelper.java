package org.bpmintegrationpaper.util;

import java.util.HashMap;
import java.util.Map;

import org.activiti.camel.ActivitiProducer;
import org.apache.camel.Handler;
import org.apache.camel.Header;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 18/04/2014
 */
public class ActivitiMessageHelper {

    private static final org.slf4j.Logger LOG = LoggerFactory
            .getLogger(ActivitiMessageHelper.class);

    /**
     * This method will extract information from the Exchange (using Camel
     * annotations) and put them in a Map that will be used for setting up the
     * process' variables.
     * 
     * @param file
     *            The File path.
     * @param from
     *            Mail From.
     * @param id
     *            Id of process.
     * @return A Map
     */
    @Handler
    public Map<String, Object> getProcessVariables(
            @Header("From") final String from,
            @Header("CamelFileNameProduced") final String file,
            @Header("breadcrumbId") final String id) {
        final Map<String, Object> variables = new HashMap<String, Object>(3);
        variables.put("file", file);
        variables.put("from", from);
        variables.put(ActivitiProducer.PROCESS_KEY_PROPERTY, id);
        LOG.error("Variables: " + variables);
        return variables;
    }
}