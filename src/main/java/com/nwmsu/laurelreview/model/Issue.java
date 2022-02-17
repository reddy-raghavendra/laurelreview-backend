package com.nwmsu.laurelreview.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.*;

@Entity
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long issueId;
	@Column
	private String issueTitle;
	@Column
	private int issueStock;
	@Column
	private boolean status;
	@Column
	private Blob issueAttachment;
	@Column
	private Blob issueImage;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "issue")	
	private List<IssueDetails> issueDetails;
	
	public Blob getIssueImage() {
		return issueImage;
	}
	public void setIssueImage(Blob issueImage) {
		this.issueImage = issueImage;
	}
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	public String getIssueTitle() {
		return issueTitle;
	}
	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}
	public int getIssueStock() {
		return issueStock;
	}
	public void setIssueStock(int issueStock) {
		this.issueStock = issueStock;
	}			
	public List<IssueDetails> getIssueDetails() {
		return issueDetails;
	}
	public void setIssueDetails(List<IssueDetails> issueDetails) {
		this.issueDetails = issueDetails;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Blob getIssueAttachment() {
		return issueAttachment;
	}
	public void setIssueAttachment(Blob issueAttachment) {
		this.issueAttachment = issueAttachment;
	}
	

}
