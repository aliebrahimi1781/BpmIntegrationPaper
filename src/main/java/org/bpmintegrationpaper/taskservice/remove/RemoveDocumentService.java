package org.bpmintegrationpaper.taskservice.remove;

import java.io.File;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 19/04/2014
 */
public class RemoveDocumentService implements JavaDelegate {

    private static final Logger LOG = LoggerFactory
            .getLogger(RemoveDocumentService.class);

    @Override
    public void execute(final DelegateExecution execution) throws Exception {
        if (execution.getVariable("filePath") instanceof String) {
            final File file = new File(
                    (String) execution.getVariable("filePath"));
            remove(file);
        } else if (execution.getVariable("filePath") instanceof File) {
            remove((File) execution.getVariable("filePath"));
        } else {
            throw new Exception("Invalid argument to file: "
                    + execution.getVariable("filePath"));
        }

    }

    /**
     * Remove a file.
     * 
     * @param file
     *            File to remove.
     */
    private void remove(final File file) {
        if (file.exists()) {
            file.delete();
        } else {
            LOG.error("File does not exists: " + file.getAbsolutePath());
        }
    }

}
