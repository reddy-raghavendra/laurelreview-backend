package com.nwmsu.laurelreview.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nwmsu.laurelreview.model.IssueDetails;
import java.util.List;

public interface IssueDetailsRepo extends JpaRepository<IssueDetails, Long> {
	@Query(value = "SELECT * FROM IssueDetails i WHERE i.issue.issueId = ?1", nativeQuery = true)
	public List<IssueDetails> getIssueDetailsbyissueId(Long issueId);
	
}
