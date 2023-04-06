package com.example.qlbh.service.impl;

import com.example.qlbh.model.Account;
import com.example.qlbh.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // query xuống database tìm user
        Account user=userRepository.findUserByEmail(username);
        // nếu user null
        if (user==null){
            System.out.println("User not found : " + username);
            throw new UsernameNotFoundException("User" + username+" was is not found in the database");
        }

        List<String> roleNames = Collections.singletonList((this.userRepository.findRoleNameByEmail(username)));


        List<GrantedAuthority> grantList = new ArrayList<>();
        for (String role : roleNames) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantList.add(authority);
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                username,user.getPassword(),grantList);
        return userDetails;

    }
}
