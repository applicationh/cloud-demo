package com.shineon.userserver.controller;


import com.shineon.usercom.entity.Category;
import com.shineon.usercom.entity.TreeNode;
import com.shineon.userserver.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Category)表控制层
 *
 * @author wsh
 * 
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 通过主键查询单条数据
     */
    @GetMapping("queryById")
    public Category queryById(Integer id) {
        return categoryService.selectById(id);
    }


    @GetMapping("queryAll")
    public TreeNode queryAll() {
       return categoryService.selectAll();
    }

     /**
     * 新增数据
     */
    @PostMapping("insert")
    public int insert(@RequestParam("name")String name,@RequestParam("parent")Integer parent) {
        Category category = new Category();
        category.setName(name);
        int add = categoryService.add(category, parent);
        return add;
    }

    @GetMapping("delete")
    public void delete(Integer id) {
        categoryService.deleteAndMove(id);
    }
    @PostMapping("update")
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }

}