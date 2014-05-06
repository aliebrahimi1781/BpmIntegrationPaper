package org.bpmintegrationpaper.taskservice.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.bpmintegrationpaper.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 21/04/2014
 */
public class UnzipService implements JavaDelegate {

    private static final Logger LOG = LoggerFactory
            .getLogger(UnzipService.class);

    @Override
    public void execute(final DelegateExecution execution) throws Exception {
        LOG.error("FormatDiscover: businesKey: "
                + execution.getProcessBusinessKey());
        LOG.error("FormatDiscover: variables names: "
                + execution.getVariableNames());
        LOG.error("FormatDiscover: variables: " + execution.getVariables());

        final String filePath = (String) execution.getVariable("filePath");
        final File file = new File(filePath);
        final Set<String> files = new HashSet<String>();
        if (file.exists()) {
            final ZipInputStream zis = new ZipInputStream(new FileInputStream(
                    file));
            ZipEntry zip = zis.getNextEntry();
            while (zip != null) {
                final byte[] buffer = new byte[1024];
                final File newFile = new File(filePath + "_" + zip.getName());
                final FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                files.add(newFile.getAbsolutePath());
                zip = zis.getNextEntry();
            }
            zis.closeEntry();
            IOUtils.closeQuietly(zis);
            execution.setVariable("filesPath", files);
        } else {
            LOG.error("File does not exists. Path: " + filePath);
        }
    }
}