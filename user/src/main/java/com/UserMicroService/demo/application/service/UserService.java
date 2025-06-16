package com.UserMicroService.demo.application.service;

import com.UserMicroService.demo.domain.model.User;
import com.UserMicroService.demo.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> listar() {
        return userRepo.findAll();
    }

    public User salvar(User userParaSalvar) {
        return userRepo.save(userParaSalvar);
    }

    public Optional<User> buscarPorEmail(String emailBusca) {
        return userRepo.findByEmail(emailBusca);
    }
}