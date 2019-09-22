package com.myproject.ssm.dao;

import com.myproject.ssm.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {


    @Select(value = "select * from tb_user where id = #{id}")
    @Results(value = {
            @Result(column = "id" , property = "id" ,id = true),
            @Result(column = "name" , property = "name" ),
            @Result(column = "id" , property = "roles",
            many = @Many(select = "com.myproject.ssm.dao.RoleDao.findByUserId",fetchType = FetchType.LAZY))
    })
    public List<User> findById(String id);


    public void save();


}
