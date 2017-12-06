package vo;

import java.io.Serializable;

public class AttachmentMappingVO implements Serializable {
	private int attachmentMappingID;
	private String attachmentName;
	private String path;
	private AttachmentVO attachmentID;
	private String date;
	
	
	public int getAttachmentMappingID() {
		return attachmentMappingID;
	}
	public void setAttachmentMappingID(int attachmentMappingID) {
		this.attachmentMappingID = attachmentMappingID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public AttachmentVO getAttachmentID() {
		return attachmentID;
	}
	public void setAttachmentID(AttachmentVO attachmentID) {
		this.attachmentID = attachmentID;
	}
	
}
