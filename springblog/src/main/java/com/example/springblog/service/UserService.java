/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springblog.service;

import com.example.springblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author vladmir
 */
@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepo userRepo;

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return (UserDetails) userRepo.findByUsername(username);
    }
    
}
