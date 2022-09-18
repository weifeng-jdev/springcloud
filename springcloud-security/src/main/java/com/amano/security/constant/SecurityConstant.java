package com.amano.security.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security")
public class SecurityConstant {
    public static String SECRET_KEY;
    public static Long EXPIRE_TIMEOUT;
    public static Long REMEMBER_EXPIRE_TIMEOUT;
    public static String ISSUER;
    public static String HEADER_TOKEN;

    public void setSecretKey(String secretKey) {
        SecurityConstant.SECRET_KEY = secretKey;
    }

    public void setExpireTimeout(Long expireTimeout) {
        SecurityConstant.EXPIRE_TIMEOUT = expireTimeout;
    }

    public void setRememberExpireTimeout(Long rememberExpireTimeout) {
        SecurityConstant.REMEMBER_EXPIRE_TIMEOUT = rememberExpireTimeout;
    }

    public void setISSUER(String ISSUER) {
        SecurityConstant.ISSUER = ISSUER;
    }

    public void setHeaderToken(String headerToken) {
        SecurityConstant.HEADER_TOKEN = headerToken;
    }
}
