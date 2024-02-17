package com.hei.dreamtip.service;

import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;

public interface AdminService {
    LoginMessage loginAdmin(LoginDTO loginDTO);
}