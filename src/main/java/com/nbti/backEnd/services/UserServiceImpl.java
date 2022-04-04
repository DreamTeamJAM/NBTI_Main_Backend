package com.nbti.backEnd.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void signUp(Users user) {
		
		userRepository.save(user);
	}

	@Override
	public List<Users> findAll() {
		
		return userRepository.findAll();
	}

}
