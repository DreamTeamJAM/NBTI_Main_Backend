package com.nbti.backEnd.services;

import java.util.List;

import com.nbti.backEnd.model.User;

public interface UserService {

	User checkedFindById(Long id);

	User update(User user);

	List<User> findAll();

	Boolean deleteById(Long id);

}
