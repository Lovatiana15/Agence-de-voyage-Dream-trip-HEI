package com.hei.dreamtip.service;

import com.hei.dreamtip.dto.AdminLoginDTO;
import com.hei.dreamtip.playloadresponse.AdminLoginMessage;

public interface AdminService {
    AdminLoginMessage loginAdmin(AdminLoginDTO adminLoginDTO);
}
