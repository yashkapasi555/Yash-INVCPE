package com.elitecore.cpe.bl.data.notification;

import java.io.Serializable;

/**
 * 
 * @author Yash.Kapasi
 *
 */
public class SMSDocumentTemplateDetailWrapperData implements Serializable {


	private static final long serialVersionUID = 1L;
	private Long documentTemplateId;
	private Long documentDetailId;
	private  byte[] Template; // Replace it with blob. 
    private String mimeType;
	public Long getDocumentTemplateId() {
		return documentTemplateId;
	}
	public void setDocumentTemplateId(Long documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}
	public byte[] getTemplate() {
		return Template;
	}
	public void setTemplate(byte[] template) {
		Template = template;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public Long getDocumentDetailId() {
		return documentDetailId;
	}
	public void setDocumentDetailId(Long documentDetailId) {
		this.documentDetailId = documentDetailId;
	}
    
    
    
}
