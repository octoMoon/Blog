/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springblog.controller;

import com.example.springblog.entity.Post;
import com.example.springblog.entity.Role;
import com.example.springblog.entity.User;
import com.example.springblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author vladmir
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserRepo repo;
    
   @GetMapping("/registration")
    public String registration(Model model) {
        

        return "registration";
    }
    
    
    
@PostMapping("/registration")
    public String addUser(User user, Model model){
        if(user != null){
            model.addAttribute("error", "error");
        return "registration";}
       user.setActive(true);
       user.setRoles(Collections.singleton(Role.USER));
       repo.save(user);
       return "redirect:/blog";
    }
    
}
