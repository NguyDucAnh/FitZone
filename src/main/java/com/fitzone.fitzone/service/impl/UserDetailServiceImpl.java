package com.fitzone.fitzone.service.impl;

import com.fitzone.fitzone.entity.UserEntity;
import com.fitzone.fitzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user;
        try {
            user = userService.getUserByUsername(username);
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User not found: " + username, ex);
        }

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRoles());

        return new User(user.getUsername(),
                user.getPassword(),
                Collections.singletonList(authority));
    }
}
