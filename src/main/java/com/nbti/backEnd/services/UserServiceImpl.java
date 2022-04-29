package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public Long signUp(Users user) {

		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());
		Users savedUser = userRepo.save(newUser);
		return savedUser.getId();
	}

	@Override
	public List<Users> findAll() {

		return userRepo.findAll();
	}

	@Override
	public Boolean logIn(String username, String password) {
		List<Users> users = userRepo.findByUsername(username);
		if (!users.isEmpty()) {
			Boolean matches = password.equals(users.get(0).getPassword());
			System.out.println("psw match: " + matches);
			return matches;
		}
		return false;
	}

	@Override
	public Optional<Users> findById(Long id) {

		return userRepo.findById(id);
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			userRepo.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	@Override
	public Users update(Users user) throws NoSuchElementException {

		Users updatingUser = findById(user.getId()).get();
		updatingUser.setUsername(user.getUsername());
		updatingUser.setPassword(user.getPassword());
		updatingUser.setRole(user.getRole());
		// Reflect.updateObject(updatingUser, user);
		return userRepo.saveAndFlush(updatingUser);
	}

}
