package com.nwmsu.laurelreview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChapBook implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long chapBookId;
	@Column
	private String chapBookName;
	@Column
	private String chapBookDesc;
	
	@Column
	private String chapBookTitle;
	//@Column
	//private String chapBookAudioFile;
	@Column
	private String chapBookCoverImage;
	@Column
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getchapBookId() {
		return chapBookId;
	}
	public void setchapBookId(Long chapBookId) {
		this.chapBookId = chapBookId;
	}
	public String getchapBookName() {
		return chapBookName;
	}
	public void setchapBookName(String chapBookName) {
		this.chapBookName = chapBookName;
	}
	public String getchapBookDesc() {
		return chapBookDesc;
	}
	public void setchapBookDesc(String chapBookDesc) {
		this.chapBookDesc = chapBookDesc;
	}
	public String getchapBookTitle() {
		return chapBookTitle;
	}
	public void setchapBookTitle(String chapBookTitle) {
		this.chapBookTitle = chapBookTitle;
	}
//	public String getchapBookAudioFile() {
//		return chapBookAudioFile;
//	}
//	public void setchapBookAudioFile(String chapBookAudioFile) {
//		this.chapBookAudioFile = chapBookAudioFile;
//	}
	public String getchapBookCoverImage() {
		return chapBookCoverImage;
	}
	public void setchapBookCoverImage(String chapBookCoverImage) {
		this.chapBookCoverImage = chapBookCoverImage;
	}

}
