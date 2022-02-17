package com.nwmsu.laurelreview.repo;

import com.nwmsu.laurelreview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
