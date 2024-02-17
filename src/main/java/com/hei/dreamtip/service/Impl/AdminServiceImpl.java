package com.hei.dreamtip.service.Impl;

import com.hei.dreamtip.Entity.Admin;
import com.hei.dreamtip.dto.LoginDTO;
import com.hei.dreamtip.playloadresponse.LoginMessage;
import com.hei.dreamtip.repo.AdminRepository;
import com.hei.dreamtip.service.AdminService;
import com.hei.dreamtip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserService userService;

    @Override
    public LoginMessage loginAdmin(LoginDTO loginDTO) {
        if (isAdminKey(loginDTO.getKey())) {
            Admin admin = adminRepository.findByEmail(loginDTO.getEmail()).orElse(null);
            if (admin != null) {
                admin.setPassword(loginDTO.getPassword());
                adminRepository.save(admin);
                return new LoginMessage("Admin credentials updated", true);
            } else {
                admin = new Admin();
                admin.setEmail(loginDTO.getEmail());
                admin.setPassword(loginDTO.getPassword());
                adminRepository.save(admin);
                return new LoginMessage("New admin created", true);
            }
        } else {
            return userService.loginUser(loginDTO);
        }
    }

    public boolean isAdminKey(String key) {
        return "super_secret_admin_key".equals(key);
    }
}