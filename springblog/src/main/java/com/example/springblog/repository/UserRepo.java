/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.springblog.repository;


import com.example.springblog.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vladmir
 */
public interface UserRepo extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
