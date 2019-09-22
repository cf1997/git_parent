package com.myproject.ssm.controller;

import com.myproject.ssm.dao.UserDao;
import com.myproject.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<User> findById(@PathVariable String id){
        return userDao.findById(id);
    }




}
