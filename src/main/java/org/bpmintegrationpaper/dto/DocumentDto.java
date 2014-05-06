package org.bpmintegrationpaper.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 16/04/2014
 */
@XmlRootElement(name = "DocumentDto")
public class DocumentDto {

    private String user;
    private String password;
    private Integer docType;
    private String format;
    private byte[] content;
    private String note;

    /**
     * Getter method to id.
     * 
     * @return the id
     */
    @XmlElement(name = "docType", required = true, nillable = false)
    public Integer getDocType() {
        return docType;
    }

    /**
     * Setter method to id.
     * 
     * @param docType
     *            the id to set
     */
    public void setDocType(final Integer docType) {
        this.docType = docType;
    }

    /**
     * Getter method to user.
     * 
     * @return the user
     */
    @XmlElement(name = "user", required = true, nillable = false)
    public String getUser() {
        return user;
    }

    /**
     * Setter method to user.
     * 
     * @param user
     *            the user to set
     */
    public void setUser(final String user) {
        this.user = user;
    }

    /**
     * Getter method to password.
     * 
     * @return the password
     */
    @XmlElement(name = "password", required = true, nillable = false)
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to password.
     * 
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Getter method to format.
     * 
     * @return the format
     */
    @XmlElement(name = "format", required = true, nillable = false)
    public String getFormat() {
        return format;
    }

    /**
     * Setter method to format.
     * 
     * @param format
     *            the format to set
     */
    public void setFormat(final String format) {
        this.format = format;
    }

    /**
     * Getter method to content.
     * @return the content
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * Setter method to content.
     * 
     * @param content
     *            the content to set
     */
    public void setContent(final byte[] content) {
        this.content = content;
    }

    /**
     * Getter method to note.
     * 
     * @return the note
     */
    @XmlElement(name = "note", required = false, nillable = false)
    public String getNote() {
        return note;
    }

    /**
     * Setter method to note.
     * 
     * @param note
     *            the note to set
     */
    public void setNote(final String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User: " + user + " DocType: " + docType + " Format: " + format
                + " Note: " + note;
    }
}
