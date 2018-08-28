package com.mybatis.service;

import com.mybatis.entities.User;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);

}
