package com.ftn.sbnz.service.services;


import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Mechanic;
import com.ftn.sbnz.service.repositories.IMechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.IClientRepository;
import com.ftn.sbnz.service.services.interfaces.IUserService;

import ftn.sbnz.model.models.Role;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    IMechanicRepository allMechanics;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("Service");
////        return new User("srki", "$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO", new ArrayList<GrantedAuthority>(){Role.CLIENT});
//        return org.springframework.security.core.userdetails.User.withUsername("srki").password("$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO").roles(Role.CLIENT.toString()).build();
        Optional<Mechanic> ret = allMechanics.getUserByUsername(username);
		if (!ret.isEmpty()) {
			return org.springframework.security.core.userdetails.User.withUsername(username).password(ret.get().getPassword()).roles(ret.get().getRole().toString()).build();
		}
		throw new UsernameNotFoundException("User not found with this username: " + username);

    }


    @Override
    public Mechanic getUserByToken() throws NotFoundException {
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        return allMechanics.findByUsername(user.getUsername()).orElseThrow(NotFoundException::new);
    }

}
