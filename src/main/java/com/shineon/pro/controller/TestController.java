package com.shineon.pro.controller;

import com.shineon.pro.entity.Role;
import com.shineon.pro.aspect.DataSource;
import com.shineon.pro.mapper.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wsh
 */
@RequestMapping("/master")
@RestController
public class TestController {

    @Autowired
    RoleDao roleDao;

    @DataSource(value="master")
    @GetMapping("master")
    public List<Role> master( ) {
        List<Role> roles = roleDao.queryAll(null);
        return roles;
    }

    @DataSource(value="slave")
    @GetMapping("slave")
    public List<Role> slave( ) {
        List<Role> roles = roleDao.queryAll(null);
        return roles;
    }



}
