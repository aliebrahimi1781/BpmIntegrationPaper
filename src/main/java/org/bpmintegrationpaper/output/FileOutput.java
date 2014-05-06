package org.bpmintegrationpaper.output;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 19/04/2014
 */
public class FileOutput implements JavaDelegate {

    private static final Logger LOG = LoggerFactory
            .getLogger(FileOutput.class);

    @Override
    public void execute(final DelegateExecution execution) throws Exception {
        LOG.error("Send document to Fiscal. " + execution.getVariableNames());
    }

}
