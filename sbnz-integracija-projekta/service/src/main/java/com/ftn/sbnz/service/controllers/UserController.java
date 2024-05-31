package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.auth.TokenUtils;
import com.ftn.sbnz.service.dtos.users.CredentialsDTO;
import com.ftn.sbnz.service.dtos.users.TokenDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
//@CrossOrigin(origins = "https://localhost:4200")
public class UserController {

    @Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
	private TokenUtils tokenUtils;


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody CredentialsDTO credentials) {
		System.out.println(credentials.getEmail());

		Authentication authentication;
		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
		} catch (BadCredentialsException e) {
			System.out.println(e);
			return new ResponseEntity<String>("Wrong username or password!", HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails user = (UserDetails) authentication.getPrincipal();
//		User userFromDb = this.userService.getUserByEmail(credentials.getEmail());

		String jwt = tokenUtils.generateToken(user);

		return new ResponseEntity<TokenDTO>(new TokenDTO(jwt, jwt), HttpStatus.OK);

	}
}
