/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.springblog.repository;

import com.example.springblog.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vladmir
 */
public interface PostRepo extends CrudRepository<Post, Long>{
    
}
