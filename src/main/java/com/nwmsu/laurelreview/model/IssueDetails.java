package com.nwmsu.laurelreview.model;

import java.io.Serializable;
import java.io.Serializable.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
@Entity
public class IssueDetails implements Serializable{
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long issueInfoId;
	@Column
	private String authorName;
	@Column
	private String authorDescription;
	@Column
	private boolean isHyperLink;
	@Column
	private int pageNo;
	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName = "issueId")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Issue issue;
	
		
//	public IssueDetails() {
//		super();
//	}
//
//	public IssueDetails(String authorName, String authorDescription, boolean isHyperLink,
//			int pageNo,Issue issue) {
//		this.authorName = authorName;
//		this.authorDescription = authorDescription;
//		this.isHyperLink = isHyperLink;
//		this.pageNo = pageNo;
//		this.issue = issue;
//	}	
	public long getIssueInfoId() {
		return issueInfoId;
	}

	public void setIssueInfoId(long issueInfoId) {
		this.issueInfoId = issueInfoId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDescription() {
		return authorDescription;
	}

	public void setAuthorDescription(String authorDescription) {
		this.authorDescription = authorDescription;
	}

	public boolean isHyperLink() {
		return isHyperLink;
	}

	public void setHyperLink(boolean isHyperLink) {
		this.isHyperLink = isHyperLink;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	
	
	
	
}
