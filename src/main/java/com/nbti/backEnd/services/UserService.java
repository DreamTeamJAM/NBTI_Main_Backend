package com.nbti.backEnd.services;

import java.util.List;

import com.nbti.backEnd.model.Users;

public interface UserService {

	void signUp(Users user);
	List<Users> findAll();
}
