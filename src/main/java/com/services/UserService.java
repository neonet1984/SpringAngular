package com.services;

import com.repository.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Role> getUserRole(Long id);


}
