package com.nwmsu.laurelreview.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nwmsu.laurelreview.model.Issue;

public interface IssueRepo extends JpaRepository<Issue,Long>{

}
