package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean validateLogin(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        // Si el usuario existe, comprueba la contraseña (en este caso simple comparación de strings)
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
