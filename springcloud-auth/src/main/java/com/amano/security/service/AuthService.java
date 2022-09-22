package com.amano.security.service;

import com.amano.security.domain.Role;
import com.amano.security.domain.User;
import com.amano.security.dto.LoginInfoDTO;
import com.amano.springcloud.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(LoginInfoDTO loginInfo) {
        Optional<User> userOptional = userService.getUserByName(loginInfo.getUsername());
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        User user = userOptional.get();
        if (bCryptPasswordEncoder.matches(user.getPassword(), loginInfo.getPassword())) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        Optional<List<Role>> roleList = roleService.listRoleByUserId(user.getId());
        List<String> roles = roleList.map(item -> item.stream().map(Role::getRoleName).collect(Collectors.toList()))
                .orElseGet(() -> Collections.singletonList("user"));
        // 生成jwt token
        String token = JwtUtil.generateToken(user.getUsername(), roles);
        Authentication authentication = JwtUtil.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return token;
    }
}
