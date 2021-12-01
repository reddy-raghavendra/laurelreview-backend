package com.nwmsu.laurelreview.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nwmsu.laurelreview.models.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
