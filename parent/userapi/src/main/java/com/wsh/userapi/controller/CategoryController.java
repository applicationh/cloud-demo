package com.wsh.userapi.controller;


import com.alibaba.fastjson.JSONObject;
import com.wsh.userapi.service.CategoryService;
import com.wsh.userapi.utils.Result;
import com.wsh.usercom.entity.Category;
import com.wsh.usercom.entity.TreeNode;
import com.wsh.usercom.entity.TreeSelect;
import com.wsh.usercom.param.CategoryParam;
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
    public List<TreeNode> queryAll(@RequestParam(required = false,name = "id",defaultValue = "-1")Integer id) {
        TreeNode treeNode = categoryService.selectAll(id);
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
        TreeNode treeNode = categoryService.selectAll(-1);
        return treeNode.getChildren();
    }


    /**
     * layui 图标树状图数据格式
     */
    @PostMapping("queryAllTable")
    public  Result<List<Category>> queryAllTable(@RequestBody(required = false) CategoryParam categoryParam) {
        if (categoryParam == null) {
            categoryParam = new CategoryParam();
        }
        List<Category> categories = categoryService.selectAllTable(categoryParam);
        return Result.success(categories);
    }

     /**
     * 新增数据
     */
    @PostMapping("insert")
    public Result insert(@RequestBody  Category category) {
        int add = categoryService.insert(category);
        return Result.success(add);
    }

    @GetMapping("delete")
    public Result delete(Integer id) {
        Category category = categoryService.selectRoot();
        if (category.getId() == id) {
            return Result.error("根目录不可删除");
        }
        categoryService.deleteAndMove(id);
        return Result.success();
    }
    @PostMapping("update")
    public Result update(@RequestBody Category category) {
        Boolean update = categoryService.update(category);
        return Result.success(update);
    }

}