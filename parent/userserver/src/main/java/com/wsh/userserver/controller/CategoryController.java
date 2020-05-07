package com.wsh.userserver.controller;


import com.wsh.usercom.entity.Category;
import com.wsh.usercom.entity.TreeNode;
import com.wsh.usercom.entity.TreeSelect;
import com.wsh.usercom.param.CategoryParam;
import com.wsh.userserver.service.CategoryService;
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
     * 查询根目录  用于校验
     */
    @GetMapping("selectRoot")
    public Category selectRoot() {
        return categoryService.selectRoot();
    }

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


    @PostMapping("selectAllTable")
    public List<Category> selectAllTable(@RequestBody(required = false)  CategoryParam categoryParam) {
       return categoryService.selectAllTable(categoryParam);
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
    public void delete(@RequestParam("id") Integer id) {
        categoryService.deleteAndMove(id);
    }
    @PostMapping("update")
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }

}