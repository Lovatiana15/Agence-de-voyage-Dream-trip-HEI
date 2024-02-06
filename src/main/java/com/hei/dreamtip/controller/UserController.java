package com.hei.dreamtip.controller;

import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin
@RestController
@RequestMapping("api/v1/user")



public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping (path = "/save")
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}

