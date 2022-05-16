package com.nbti.backEnd.utils;

import java.util.NoSuchElementException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.nbti.backEnd.model.Student;
import com.nbti.backEnd.model.Users;

public class AuthUtils {

	public static void authUser(Users user) throws NoSuchElementException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		System.out.println(user.getUsername());
		boolean goodUser = user.getUsername().equals(auth.getName());
		boolean isAdmin = isAdmin(auth);
		System.out.println("admin: " + isAdmin);
		if (!(isAdmin || goodUser)) {
			throw new NoSuchElementException();
		}
		System.out.println("authenticated successfully");
	}

	private static boolean isAdmin(Authentication auth) {
		return auth.getAuthorities().stream().anyMatch(a -> {
			System.out.println(a);
			return a.getAuthority().equals("admin");
		});
	}

	public static void authStudent(Student st) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	}

	public static String getUsername() {

		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
