package com.example.postDo.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.postDo.auth.JwtAuthenticationRequest;
import com.example.postDo.entity.User;
import com.example.postDo.entity.UserTokenState;
import com.example.postDo.security.TokenHelper;
import com.example.postDo.service.CustomUserDetailsService;


@RestController
@RequestMapping(value = "api/auth")
@CrossOrigin("*")
public class AuthenticationController {

//	 @Autowired
//	    TokenHelper tokenHelper;
//
//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @Autowired
//	    private CustomUserDetailsService userDetailsService;
//
//
////	    @RequestMapping(value = "/login", method = RequestMethod.POST)
////	    public ResponseEntity<?> createAuthenticationToken(
////	            @RequestBody JwtAuthenticationRequest authenticationRequest,
////	            HttpServletResponse response
////	    ) throws AuthenticationException, IOException {
////
////	        // Izvrsavanje security dela
////	        final Authentication authentication = authenticationManager.authenticate(
////	                new UsernamePasswordAuthenticationToken(
////	                        authenticationRequest.getUsername(),
////	                        authenticationRequest.getPassword()
////	                )
////	        );
////
////	        // Ubaci username + password u kontext
////	        SecurityContextHolder.getContext().setAuthentication(authentication);
////
////	        // Kreiraj token
////	        User user = (User)authentication.getPrincipal();
////	        String jws = tokenHelper.generateToken( user.getUsername());
////
////	        // Vrati token kao odgovor na uspesno autentifikaciju
////	        return ResponseEntity.ok(new UserTokenState(jws));
////	    }
//	    
//	    @PostMapping(value = "/login")
//	    public ResponseEntity<?> authenticateUser(@RequestBody JwtAuthenticationRequest tokenRequest) throws AuthenticationException, IOException {
//	        UsernamePasswordAuthenticationToken authenticationRequest = new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword());
//	       System.out.println(tokenRequest.getUsername() + tokenRequest.getPassword());
//	        final Authentication authentication;
//	       
//	        try {
//	            authentication = authenticationManager.authenticate(authenticationRequest);
//	        } catch (AuthenticationException ex) {
//	        	System.out.println("failed");
//	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//	        }
//	       
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	       
//	        User user = (User) authentication.getPrincipal();
//	       
//	        String token = tokenHelper.generateToken(user.getUsername());
//	        return ResponseEntity.ok(new UserTokenState(token));
//	    }
//
//	    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
//	    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
//	        userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
//	        return new ResponseEntity<>(HttpStatus.OK);
//	    }
//
//	    static class PasswordChanger {
//	        public String oldPassword;
//	        public String newPassword;
//	    }
}
