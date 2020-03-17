package com.gem.tradesystem.service;

public interface RegService {
    boolean insertUser(String password, String telephone, String username);

    Boolean verifyTel(String telephone);

    Boolean verifyUsername(String username);
}
