package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.config.UploadProperties;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.UserSettingMapper;
import com.gem.tradesystem.service.UploadFile;
import com.gem.tradesystem.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserSettingServiceImpl implements UserSettingService {
    @Autowired
    private UserSettingMapper userSettingMapper;
    @Autowired
    private UploadProperties uploadProperties;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Boolean updateUserById(Integer id, String username, String sex, String avatar) {
        Boolean flag = userSettingMapper.updateUserByid(id,username,sex,avatar);
        return flag;
    }

    @Override
    public Integer modifyUsername(Integer id, String username) {
        return userSettingMapper.modifyUsername(id,username);
    }

    @Override
    public Integer confirmUsername(String username) {
        return userSettingMapper.confirmUsername(username);
    }

    @Override
    public User selectUserById(Integer id) {
        return userSettingMapper.selectUserById(id);
    }

    @Override
    public Integer uploadAvatar(Integer id, MultipartFile file) {
        UploadFile uploadFile = new UploadFileQiniu(uploadProperties.getQiniu());
        String avatar = uploadFile.uploadFile(file);
        return userSettingMapper.uploadAvatar(id,avatar);
    }

    @Override
    public Boolean confirmPassword(Integer id, String password) {
        User user = userSettingMapper.selectUserById(id);
        String mysqlPassword = user.getPassword();
        if (encoder.matches(password,mysqlPassword)){
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyPassword(Integer id, String password) {
        User user = userSettingMapper.selectUserById(id);
        password = encoder.encode(password);
        return userSettingMapper.updateUPasswordById(id,password);
    }
}
