package vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AttachmentVO implements Serializable {
	private int attachmentID;
	private String attachmentType;

	private Set attachset =	new HashSet(0);

	public int getAttachmentID() {
		return attachmentID;
	}

	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Set getAttachset() {
		return attachset;
	}

	public void setAttachset(Set attachset) {
		this.attachset = attachset;
	}

	
	

}
