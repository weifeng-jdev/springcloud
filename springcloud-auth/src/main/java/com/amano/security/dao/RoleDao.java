package com.amano.security.dao;

import com.amano.security.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends BaseMapper<Role> {
    @Select("select r.* from role r inner join user_role ur on r.id = ur.role_id where ur.user_id = #{userId}")
    List<Role> listRoleByUserId(@Param("userId") Long userId);
}
