package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.repositories.UserRepository;
import com.nbti.backEnd.utils.AuthUtils;
import com.nbti.backEnd.utils.Reflect;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder pswEnc;

	@Override
	public Long signUp(Users user) {

		Users newUser = new Users();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(pswEnc.encode(user.getPassword()));
//		newUser.setRole(user.getRole());
		newUser.setRole("student");
		
		Users savedUser = save(newUser);
		return savedUser.getId();
	}

	public Users save(Users user) {
		Reflect.UpdateDates(user);
		return userRepo.saveAndFlush(user);
	}

	@Override
	public List<Users> findAll() {

		return userRepo.findAll();
	}

	@Override
	public Boolean logIn(String username, String password) {
		List<Users> users = userRepo.findByUsername(username);
		if (!users.isEmpty()) {
			Boolean matches = pswEnc.matches(password, users.get(0).getPassword());
//			Boolean matches = password.equals(users.get(0).getPassword());
			System.out.println("psw match: " + matches);
			return matches;
		}
		return false;
	}

	@Override
	public Users checkedFindById(Long id) {
		Users user = userRepo.findById(id).get();
		AuthUtils.authUser(user);

		return user;
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

		Users updatingUser = checkedFindById(user.getId());

		updatingUser.setUsername(user.getUsername());
		updatingUser.setPassword(pswEnc.encode(user.getPassword()));
		updatingUser.setRole(user.getRole());
		// Reflect.updateObject(updatingUser, user);
		return save(updatingUser);
	}

	@Override
	public boolean logOut() {
		// TODO Auto-generated method stub
		return true;
	}

}
