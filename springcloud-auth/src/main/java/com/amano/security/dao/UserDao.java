package com.amano.security.dao;

import com.amano.security.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user where username = #{username} limit 1")
    User getUserByName(@Param("username") String username);

    @Select("select * from user")
    List<User> listUser();
}
