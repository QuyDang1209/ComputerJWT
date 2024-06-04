package org.example.computerspringjwt.config.service;

import org.example.computerspringjwt.config.UserPrinciple;
import org.example.computerspringjwt.model.User;
import org.example.computerspringjwt.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    public User findUserByName(String name){
        return userRepository.findUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findUserByUsername(username));
    }
}
