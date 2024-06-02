package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Mechanic;

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
import com.ftn.sbnz.service.repositories.IMechanicRepository;
import com.ftn.sbnz.service.services.interfaces.IUserService;

import ftn.sbnz.model.models.Role;

import java.util.ArrayList;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IMechanicRepository mechanicRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Service");
        Car c = new Car();
//        return new User("srki", "$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO", new ArrayList<GrantedAuthority>(){Role.CLIENT});
        return org.springframework.security.core.userdetails.User.withUsername("srki").password("$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO").roles(Role.CLIENT.toString()).build();

    }


    @Override
    public Mechanic getUserByToken() throws NotFoundException {
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        return mechanicRepository.findByUsername(user.getUsername()).orElseThrow(NotFoundException::new);
    }

}
