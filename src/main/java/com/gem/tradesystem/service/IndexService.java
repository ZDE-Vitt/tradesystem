package com.gem.tradesystem.service;


import com.gem.tradesystem.entity.User;

public interface IndexService {
    User login(String telephone, String password);
}
