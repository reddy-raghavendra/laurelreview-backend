package com.nwmsu.laurelreview.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Issue implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long issueId;
	@Column
	private String issueTitle;
	@Column
	private int issueStock;
	@Column
	private boolean status;
	@Column
	private String issueAttachment;
	@Column
	private String issueImage;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "issue",fetch=FetchType.LAZY)
//	@OneToMany(cascade = CascadeType.ALL,targetEntity = IssueDetails.class)
//	@JoinColumn(name="id_fk",referencedColumnName = "issueId")
	private List<IssueDetails> issueDetails;
	
//	public Issue() {
//	}
//	
//	public Issue(String issueTitle, int issueStock, boolean status, String issueAttachment,
//			String issueImage, List<IssueDetails> issueDetails) {
//		this.issueTitle = issueTitle;
//		this.issueStock = issueStock;
//		this.status = status;
//		this.issueAttachment = issueAttachment;
//		this.issueImage = issueImage;
//		this.issueDetails = issueDetails;
//	}
	public String getIssueImage() {
		return issueImage;
	}
	public void setIssueImage(String issueImage) {
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
		for(IssueDetails issueDetail:issueDetails) {
			issueDetail.setIssue(this);
		}
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getIssueAttachment() {
		return issueAttachment;
	}
	public void setIssueAttachment(String issueAttachment) {
		this.issueAttachment = issueAttachment;
	}	

}
