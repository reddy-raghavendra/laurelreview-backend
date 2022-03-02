package com.nwmsu.laurelreview.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwmsu.laurelreview.repo.IssueDetailsRepo;
import com.nwmsu.laurelreview.repo.IssueRepo;
import com.nwmsu.laurelreview.model.Issue;
import com.nwmsu.laurelreview.model.IssueDetails;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("api")
public class IssueController {
//	@Autowired
	private IssueRepo issueRepo;
//	@Autowired
	private IssueDetailsRepo issueDetailsRepo;
	@Autowired
	public IssueController(IssueRepo issueRepo,IssueDetailsRepo issueDetailsRepo) {
		this.issueRepo = issueRepo;
		this.issueDetailsRepo = issueDetailsRepo;
	}
	
	@GetMapping(value = "/issues")
	public List<Issue> getIssues(){
//		List<Issue> issues = issueRepo.findAll();
//		System.out.println(issues);
		return issueRepo.findAll();
	}
	
	@GetMapping(value = "/issues/{issueId}")
	public Issue getIssue(@PathVariable Long issueId) {
		return issueRepo.findById(issueId).orElse(null);
	}
	
	@PostMapping(value="/issues/save")
	public String saveIssue(@RequestBody Issue issue) {
		issueRepo.save(issue);
		return "Saved successfully";
	}
	
	@PutMapping(value="issues/save/{issueId}")
	public String updateIssue(@RequestBody Issue updatedIssue,@PathVariable long issueId) {
		Issue issue = issueRepo.findById(issueId).orElse(null);
		if(issue == null) {
			return "No Record found for id"+issueId;
		}
		BeanUtils.copyProperties(updatedIssue, issue);
		this.saveIssue(issue);
		return "Updated..";
	}
	
	@DeleteMapping(value="issues/delete/{issueId}")
	public String deleteIssue(@PathVariable long issueId) {
		issueRepo.deleteById(issueId);
		return "Deleted";
	}
	
}
