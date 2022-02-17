package com.nwmsu.laurelreview.model;

import java.io.Serializable.*;
import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
@Entity
public class IssueDetails{
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
	@ManyToOne
	@JoinColumn(referencedColumnName = "issueId")
	private Issue issue;
	
	
}
