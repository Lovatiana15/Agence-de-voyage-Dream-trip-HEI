package com.hei.dreamtip.service;

import com.hei.dreamtip.dto.UserInfoDTO;
import com.hei.dreamtip.dto.UserLoginHistoryDTO;

import java.util.List;


public interface UserInfoService {
    UserInfoDTO getUserInfo(String username);
    List<UserLoginHistoryDTO> getUserLoginHistory(String username);
}