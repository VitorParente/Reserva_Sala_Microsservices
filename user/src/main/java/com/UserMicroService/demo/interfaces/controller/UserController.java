package com.UserMicroService.demo.interfaces.controller;

import com.UserMicroService.demo.application.service.UserService;
import com.UserMicroService.demo.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> buscarTodos() {
        return userService.listar();
    }

    @PostMapping("/salvar")
    public User adicionar(@RequestBody User novoUser) {
        return userService.salvar(novoUser);
    }
}
