package com.hei.dreamtip.service.Impl;

import com.hei.dreamtip.Entity.User;
import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.repo.UserRepo;
import com.hei.dreamtip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUsername(),
                userDTO.getUserLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(), // Utilisez le mot de passe tel quel
                userDTO.getPhoneNumber(),
                userDTO.getAddress()
        );
        userRepo.save(user);
        return user.getUsername();
    }

    @Override
    public void save(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUsername(),
                userDTO.getUserLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(), // Utilisez le mot de passe tel quel
                userDTO.getPhoneNumber(),
                userDTO.getAddress()
        );
        userRepo.save(user);
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String storedPassword = user.getPassword();
            if (password.equals(storedPassword)) { // Comparaison de mots de passe sans hachage
                return new LoginMessage("Login Success", true);
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exists", false);
        }
    }
}
