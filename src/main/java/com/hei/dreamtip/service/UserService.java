package com.hei.dreamtip.service;

import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.dto.UserDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);

    void save(UserDTO userDTO);
}