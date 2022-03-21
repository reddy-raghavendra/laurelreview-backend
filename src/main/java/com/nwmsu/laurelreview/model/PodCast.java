package com.nwmsu.laurelreview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PodCast implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long podcastId;
	@Column
	private String podcastName;
	@Column
	private String podcastDesc;
	@Column
	private String podcastDate;
	@Column
	private String podcastAudioFile;
	@Column
	private String podcastCoverImage;
	public Long getPodcastId() {
		return podcastId;
	}
	public void setPodcastId(Long podcastId) {
		this.podcastId = podcastId;
	}
	public String getPodcastName() {
		return podcastName;
	}
	public void setPodcastName(String podcastName) {
		this.podcastName = podcastName;
	}
	public String getPodcastDesc() {
		return podcastDesc;
	}
	public void setPodcastDesc(String podcastDesc) {
		this.podcastDesc = podcastDesc;
	}
	public String getPodcastDate() {
		return podcastDate;
	}
	public void setPodcastDate(String podcastDate) {
		this.podcastDate = podcastDate;
	}
	public String getPodcastAudioFile() {
		return podcastAudioFile;
	}
	public void setPodcastAudioFile(String podcastAudioFile) {
		this.podcastAudioFile = podcastAudioFile;
	}
	public String getPodcastCoverImage() {
		return podcastCoverImage;
	}
	public void setPodcastCoverImage(String podcastCoverImage) {
		this.podcastCoverImage = podcastCoverImage;
	}

}
