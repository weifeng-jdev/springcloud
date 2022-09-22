package com.amano.security.service;

import com.amano.security.dao.RoleDao;
import com.amano.security.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Optional<List<Role>> listRoleByUserId(Long userId) {
        return Optional.ofNullable(roleDao.listRoleByUserId(userId));
    }
}
