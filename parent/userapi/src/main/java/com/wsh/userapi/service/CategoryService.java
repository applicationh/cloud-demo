package com.wsh.userapi.service;


import com.wsh.usercom.entity.Category;
import com.wsh.usercom.entity.TreeNode;
import com.wsh.usercom.entity.TreeSelect;
import com.wsh.usercom.param.CategoryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author wsh
 * 
 */
@FeignClient(name = "userserver")
@Service
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     */
    @GetMapping("category/queryById")
    Category selectById(@RequestParam("id")Integer id);

    @GetMapping("category/selectRoot")
    Category selectRoot();

    @PostMapping("category/insert")
    int insert(@RequestBody Category category);
    @PostMapping("category/update")
    Boolean update(@RequestBody Category category);




    @GetMapping("category/queryAll")
    TreeNode selectAll(@RequestParam("id")Integer id);

    @PostMapping("category/selectAllTable")
    List<Category> selectAllTable(@RequestBody   CategoryParam categoryParam);


    @GetMapping("category/delete")
    void deleteAndMove(@RequestParam("id")Integer id);


}