/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springblog.controller;

import com.example.springblog.entity.Post;
import com.example.springblog.entity.User;
import com.example.springblog.repository.PostRepo;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        Iterable<Post> posts = repo.findAll();
        model.addAttribute("posts", posts);
        return "blog";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        return "blogAdd";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(
            @AuthenticationPrincipal User user,
            @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String fullText, Model model) {
        Post post = new Post(title, anons, fullText, user);
        repo.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!repo.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = repo.findById(id);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!repo.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = repo.findById(id);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title,
            @RequestParam String anons,
            @RequestParam String fullText, Model model) {
        Post post = repo.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        repo.save(post);
        return "redirect:/blog/{id}";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDel(@PathVariable(value = "id") long id, Model model) {
        Post post = repo.findById(id).orElseThrow();
        repo.delete(post);
        return "redirect:/blog";
    }
}
