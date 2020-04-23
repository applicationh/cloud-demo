package com.shineon.userapi.service;


import com.shineon.usercom.entity.Category;
import com.shineon.usercom.entity.TreeNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
    Category selectById(Integer id);

    @PostMapping("category/insert")
    int insert(@RequestParam("name")String name,@RequestParam("parent")Integer parent);
    @PostMapping("category/update")
    Boolean update(@RequestBody Category category);




    @GetMapping("category/queryAll")
    TreeNode selectAll();



    @GetMapping("category/delete")
    void deleteAndMove(int id);


}