package com.nbti.backEnd.security;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.nbti.backEnd.model.Users;
import com.nbti.backEnd.repositories.UserRepository;

@Component
public class NBTIUserDetailsService{

	@Autowired 
	private UserRepository userRepository;
	

}
