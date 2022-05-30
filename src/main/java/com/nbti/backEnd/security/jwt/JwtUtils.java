package com.nbti.backEnd.security.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.nbti.backEnd.security.services.UserDetailsImpl;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	@Value("${nbti.app.jwtSecret}")
	private String jwtSecret;
	@Value("${nbti.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			System.err.println("Invalid JWT signature: {}" + e.getMessage());
		} catch (MalformedJwtException e) {
			System.err.println("Invalid JWT token: {}" + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.err.println("JWT token is expired: {}" + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.err.println("JWT token is unsupported: {}" + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println("JWT claims string is empty: {}" + e.getMessage());
		}
		return false;
	}
}
