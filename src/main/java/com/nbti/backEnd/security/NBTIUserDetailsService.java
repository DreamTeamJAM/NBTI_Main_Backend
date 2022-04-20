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
public class NBTIUserDetailsService implements UserDetailsService{

	@Autowired 
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepository.findByUsername(username).get(0);
		
		if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		
	    return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
