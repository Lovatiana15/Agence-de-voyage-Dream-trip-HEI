package com.hei.dreamtip.service.Impl;

import com.hei.dreamtip.Entity.User;
import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.repo.UserRepo;
import com.hei.dreamtip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUsername(),
                userDTO.getUserLastName(),
                userDTO.getEmail(),
                userDTO.getPhoneNumber(),
                this.passwordEncoder.encode(userDTO.getPassword())
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
                userDTO.getPhoneNumber(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
    }
    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> optionalUser = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (optionalUser.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exists", false);
        }
    }
}
