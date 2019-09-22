package com.myproject.ssm.dao;

import com.myproject.ssm.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select(value = "select * from tb_role where id in" +
            " (select role_id from tb_user_role where user_id = #{userId})")
    public List<Role> findByUserId(String userId);



}
