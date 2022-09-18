package com.amano.security.dto;

import lombok.Data;

@Data
public class LoginInfoDTO {

    private String username;
    private String password;

    private boolean remindMe;
}
