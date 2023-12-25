package com.example.demo.securityConfig;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepo.findByUserName(username);
        System.out.println(users);
        return users.map(UsersDetails::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("username not found"));

    }
}
