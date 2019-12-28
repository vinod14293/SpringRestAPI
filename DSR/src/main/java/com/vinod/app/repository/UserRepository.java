package com.vinod.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vinod.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	public User findByUserName(String User);


}
