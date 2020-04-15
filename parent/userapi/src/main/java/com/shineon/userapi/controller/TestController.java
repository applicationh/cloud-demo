package com.shineon.userapi.controller;

import com.shineon.userapi.entity.Role;
import com.shineon.userapi.dao.RoleDao;
import com.shineon.userapi.utils.Result;
import com.shineon.usercom.vo.WshTest;
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

    @GetMapping("master")
    public Result master( ) {
        WshTest a=new WshTest();
        List<Role> roles = roleDao.queryAll(null);
        return Result.success(roles);
    }

    @GetMapping("slave")
    public Result slave( ) {
        List<Role> roles = roleDao.queryAll(null);
        return Result.error("不想说话");
    }



}
