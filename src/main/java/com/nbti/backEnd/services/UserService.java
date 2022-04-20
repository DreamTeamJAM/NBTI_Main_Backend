package com.nbti.backEnd.services;

import java.util.List;
import java.util.Optional;

import com.nbti.backEnd.model.Users;

public interface UserService {

	Long signUp(Users user);

	Boolean logIn(String username, String password);

	Optional<Users> findById(Long id);

	Users update(Users user);

	List<Users> findAll();

	Boolean deleteById(Long id);
}
