package com.shineon.userapi.controller;


import com.shineon.userapi.service.CategoryService;
import com.shineon.usercom.entity.Category;
import com.shineon.usercom.entity.TreeNode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<TreeNode> queryAll() {
        TreeNode treeNode = categoryService.selectAll();
        List<TreeNode> children = treeNode.getChildren();


        //默认root 和一级展开
        treeNode.setSpread(true);
        for (TreeNode node : children) {
            node.setSpread(true);
        }
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(treeNode);
        return treeNodes;
    }
    @GetMapping("queryAllNotRoot")
    public List<TreeNode> queryAllNotRoot() {
        TreeNode treeNode = categoryService.selectAll();
        return treeNode.getChildren();
    }

     /**
     * 新增数据
     */
    @PostMapping("insert")
    public int insert(@RequestParam("name")String name,@RequestParam("parent")Integer parent) {
        Category category = new Category();
        category.setName(name);
        int add = categoryService.insert(name, parent);
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