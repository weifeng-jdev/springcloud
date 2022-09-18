package com.amano.security.service;

import com.amano.security.dao.UserDao;
import com.amano.security.domain.User;
import com.amano.security.security.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");  //配置角色
        //用户名，密码可以从数据库查询
        User user = userDao.getUserByName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("username not found");
        }
        return new UserDetail().setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAuthorities(auths)
                .setEnabled(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true)
                .setAccountNonExpired(true);
    }
}
