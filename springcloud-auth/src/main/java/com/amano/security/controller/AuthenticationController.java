package com.amano.security.controller;

import com.amano.common.dto.BaseResult;
import com.amano.security.dto.LoginInfoDTO;
import com.amano.security.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public BaseResult login(@RequestBody LoginInfoDTO loginInfo) {
        return BaseResult.success(authService.login(loginInfo));
    }

    @PostMapping("/logout")
    public BaseResult logout() {
        SecurityContextHolder.clearContext();
        return BaseResult.success();
    }
}
