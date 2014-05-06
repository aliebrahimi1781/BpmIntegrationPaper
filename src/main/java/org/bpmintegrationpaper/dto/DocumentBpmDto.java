package org.bpmintegrationpaper.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 27/04/2014
 */
public class DocumentBpmDto extends HashMap<String, Object> {

    /**
     * long attribute for DocumentBpmDto.java.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param variables
     *            Document Bpm Variables.
     */
    public DocumentBpmDto(final Map<String, Object> variables) {
        this.setDocType(variables.get("docType"));
        this.setFilePath(variables.get("filePath"));
        this.setFormat(variables.get("format"));
        this.setNote(variables.get("note"));
        this.setPassword(variables.get("password"));
        this.setUser(variables.get("user"));
    }

    /**
     * Constructor.
     */
    public DocumentBpmDto() {
    }

    /**
     * Get.
     * 
     * @param user
     *            .
     */
    public void setUser(final Object user) {
        this.put("user", user);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getUser() {
        return this.get("user");
    }

    /**
     * Get.
     * 
     * @param password
     *            .
     */
    public void setPassword(final Object password) {
        this.put("passwrod", password);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getPassword() {
        return this.get("password");
    }

    /**
     * Get.
     * 
     * @param docType
     *            .
     */
    public void setDocType(final Object docType) {
        this.put("docType", docType);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getDocType() {
        return this.get("docType");
    }

    /**
     * Get.
     * 
     * @param format
     *            .
     */
    public void setFormat(final Object format) {
        this.put("format", format);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getFormat() {
        return this.get("format");
    }

    /**
     * Get.
     * 
     * @param filePath
     *            .
     */
    public void setFilePath(final Object filePath) {
        this.put("filePath", filePath);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getFilePath() {
        return this.get("filePath");
    }

    /**
     * Get.
     * 
     * @param note
     *            .
     */
    public void setNote(final Object note) {
        this.put("note", note);
    }

    /**
     * Set.
     * 
     * @return .
     */
    public Object getNote() {
        return this.get("note");
    }
}
