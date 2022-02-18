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

import com.nwmsu.laurelreview.repo.IssueRepo;
import com.nwmsu.laurelreview.model.Issue;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@RestController
@RequestMapping("api")
public class IssueController {
	private final IssueRepo issueRepo;
	
	@Autowired
	public IssueController(IssueRepo issueRepo) {
		this.issueRepo = issueRepo;
	}
	
	@GetMapping(value = "/issues")
	public List<Issue> getIssues(){
		return issueRepo.findAll();
	}
	
	@GetMapping(value = "/issues/{issueId}")
	public Issue getIssue(long id) {
		return issueRepo.findById(id).orElse(null);
	}
	
	@PostMapping(value="/issues/save")
	public String saveIssue(@RequestBody Issue issue) {
		issueRepo.save(issue);
		return "Saved Successfully";
	}
	

	
}
