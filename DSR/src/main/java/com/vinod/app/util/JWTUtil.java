package com.vinod.app.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.security.core.userdetails.UserDetails;

//classes JWT library for getting claims from JWT
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//responsible for creating and validating JWT tokens


@Component
public class JWTUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629420333983391539L;

	//provide the amount of time JWT can persist
	public static final long JWT_TOKEN_VALIDITY = 100000;
	
	@Value("${jwt.secret}")
	private String secret;
	
	//Retrieve user name from jwt Token
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims :: getSubject);
	}

	//Retrieve Expiration date from jwt Token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims :: getExpiration);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	//check if token has expired
	private boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(expiration);
	}
	
	//generate Token for user
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}
	
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY)).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	//Validate Token
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = getUserNameFromToken(token);
		return(userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
