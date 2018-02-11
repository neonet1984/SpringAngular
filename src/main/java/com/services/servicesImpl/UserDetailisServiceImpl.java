package com.services.servicesImpl;

import com.repository.UserRepository;
import com.repository.entity.Role;
import com.repository.entity.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailisServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = null;
        List<Role> listRole;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        try {
            user = userRepository.findByName(userName);
            listRole = userService.getUserRole(user.getId());
            for (Role role : listRole) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            }

        } catch (Exception e) {
            return null;
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
    }
}
