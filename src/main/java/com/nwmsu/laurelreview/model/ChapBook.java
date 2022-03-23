


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
	private String chapBookDate;
	@Column
	private String chapBookAudioFile;
	@Column
	private String chapBookCoverImage;
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
	public String getchapBookDate() {
		return chapBookDate;
	}
	public void setchapBookDate(String chapBookDate) {
		this.chapBookDate = chapBookDate;
	}
	public String getchapBookAudioFile() {
		return chapBookAudioFile;
	}
	public void setchapBookAudioFile(String chapBookAudioFile) {
		this.chapBookAudioFile = chapBookAudioFile;
	}
	public String getchapBookCoverImage() {
		return chapBookCoverImage;
	}
	public void setchapBookCoverImage(String chapBookCoverImage) {
		this.chapBookCoverImage = chapBookCoverImage;
	}

}
