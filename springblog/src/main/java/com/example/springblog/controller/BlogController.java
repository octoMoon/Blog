/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springblog.controller;

import com.example.springblog.entity.Post;
import com.example.springblog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vladmir
 */

@Controller
public class BlogController {
    
    @Autowired
    private PostRepo repo;
    
    @GetMapping("/blog")
    public String blog(Model model) {
        Iterable<Post> posts =repo.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }
}
