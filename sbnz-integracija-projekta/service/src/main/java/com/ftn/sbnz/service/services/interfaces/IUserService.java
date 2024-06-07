package com.ftn.sbnz.service.services.interfaces;
import org.springframework.security.core.userdetails.User;

import com.ftn.sbnz.model.models.Mechanic;
import com.ftn.sbnz.service.exceptions.NotFoundException;

public interface IUserService {

    public Mechanic getUserByToken() throws NotFoundException;
}
