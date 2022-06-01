package com.nbti.backEnd.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.User;
import com.nbti.backEnd.repositories.StudentRepository;
import com.nbti.backEnd.repositories.UserRepository;
import com.nbti.backEnd.utils.AuthUtils;
import com.nbti.backEnd.utils.Reflect;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StudentRepository stRepo;

	@Autowired
	private PasswordEncoder pswEnc;

	

	public User save(User user) {
		Reflect.UpdateDates(user);
		return userRepo.saveAndFlush(user);
	}

	@Override
	public List<User> findAll() {

		return userRepo.findAll();
	}


	@Override
	public User checkedFindById(Long id) {
		User user = userRepo.findById(id).get();
		AuthUtils.authUser(user);

		return user;
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			stRepo.findAll().stream().filter((s)-> s.getUser().getId().equals(id)).forEach(s -> stRepo.delete(s));
			userRepo.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	@Override
	public User update(User user) throws NoSuchElementException {

		User updatingUser = checkedFindById(user.getId());

		updatingUser.setUsername(user.getUsername());
		updatingUser.setPassword(pswEnc.encode(user.getPassword()));
		updatingUser.setRoles(user.getRoles());
		// Reflect.updateObject(updatingUser, user);
		return save(updatingUser);
	}

}
