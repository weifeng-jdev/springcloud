package com.amano.security.service;

import com.amano.security.dao.UserDao;
import com.amano.security.domain.User;
import com.amano.security.dto.LoginInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public List<User> listUsers() {
        return userDao.listUser();
    }

    public Optional<User> getUserByName(String username) {
        return Optional.ofNullable(userDao.getUserByName(username));
    }
}
