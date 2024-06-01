package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Car;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ftn.sbnz.service.services.interfaces.IUserService;

import ftn.sbnz.model.models.Role;

import java.util.ArrayList;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Service");
        Car c = new Car();
//        return new User("srki", "$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO", new ArrayList<GrantedAuthority>(){Role.CLIENT});
        return org.springframework.security.core.userdetails.User.withUsername("srki").password("$2a$10$PAxJbDh4cVaAPr5PMjYY.OGWt.l2QOcQOct9rt4soyek2t2En4ZGO").roles(Role.CLIENT.toString()).build();

    }
}
