package org.bpmintegrationpaper.taskservice.validate;


import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.bpmintegrationpaper.dto.DocumentBpmDto;
import org.bpmintegrationpaper.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 18/04/2014
 */
public class ValidateService implements JavaDelegate {

    private static final byte[] MAGIC = {'P', 'K', 0x3, 0x4};

    private static final Logger LOG = LoggerFactory
            .getLogger(ValidateService.class);

    @Override
    public void execute(final DelegateExecution execution) throws Exception {
        LOG.error("FormatDiscover: businesKey: "
                + execution.getProcessBusinessKey());
        LOG.error("FormatDiscover: variables names: "
                + execution.getVariableNames());
        LOG.error("FormatDiscover: variables: " + execution.getVariables());
        String format = "invalid";
        final DocumentBpmDto dto = new DocumentBpmDto(execution.getVariables());
        final File file = new File((String) dto.getFilePath());
        format = validate(file);
        dto.setFormat(format);
        execution.setVariables(dto);

    }

    /**
     * @param file
     *            The file.
     * @return If it is valid.
     * @throws Exception
     *             When cow go to brejo.
     */
    protected String validate(final File file) throws Exception {
        final int readBytes = 1024;
        String format = "invalid";
        if (file.exists() && file.length() > 0) {
            FileInputStream fis = null;
            byte[] buff = null;
            try {
                fis = new FileInputStream(file);
                buff = new byte[readBytes];
                fis.read(buff);
            } finally {
                IOUtils.closeQuietly(fis);
            }
            final Pattern xmlPattern = Pattern.compile("<");
            final Matcher xmlMatcher =
                    xmlPattern.matcher(new String(buff).trim()
                            .toLowerCase());
            if (xmlMatcher.find()) {
                format = "xml";
            } else {
                final Pattern jsonPattern = Pattern.compile(":");
                final Matcher jsonMatcher =
                        jsonPattern.matcher(new String(buff).trim()
                                .toLowerCase());
                if (jsonMatcher.find()) {
                    format = "json";
                } else {
                    final Pattern csvPattern = Pattern.compile(",");
                    final Matcher csvMatcher =
                            csvPattern.matcher(new String(buff).trim()
                                    .toLowerCase());
                    if (csvMatcher.find()) {
                        format = "csv";
                    } else  if (buff[0] == MAGIC[0] && buff[1] == MAGIC[1]
                            && buff[2] == MAGIC[2] && buff[3] == MAGIC[3]) {
                        format = "zip";
                    } else {
                        LOG.error("Fail, document does not exists!");
                    }
                }

            }
        }
        return format;
    }
}