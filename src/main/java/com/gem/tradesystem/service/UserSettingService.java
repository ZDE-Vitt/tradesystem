package com.gem.tradesystem.service;

import com.gem.tradesystem.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserSettingService {

    Boolean updateUserById(Integer id, String username, String sex, String avatar);

    Integer modifyUsername(Integer id, String username);

    Integer confirmUsername(String username);

    User selectUserById(Integer id);

    Integer uploadAvatar(Integer id, MultipartFile file);

    Boolean confirmPassword(Integer id, String password);

    Boolean modifyPassword(Integer id, String password);
}
