package com.nbti.backEnd.services;

import java.util.List;

import com.nbti.backEnd.model.Users;

public interface UserService {

	Long signUp(Users user);

	Long logIn();

	Users checkedFindById(Long id);

	Users update(Users user);

	List<Users> findAll();

	Boolean deleteById(Long id);

	boolean logOut();
}
