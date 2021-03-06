package com.wsh.userserver.service;


import com.wsh.usercom.entity.Category;
import com.wsh.usercom.orther.TreeNode;
import com.wsh.usercom.param.CategoryParam;

import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author wsh
 * 
 */
public interface CategoryService {

    /**
     * 通过ID查询单条数据
     */
    Category selectById(Integer id);

    int add(Category category, int parent);

    Boolean update(Category category);


    int count();

    int countOfLayer(int layer);


    Category getParent(int id);

    Category getAncestor(int id, int n);

    TreeNode selectAll(Integer openLevel);

    List<Category> getChildren(int id);

    List<Category> getChildren(int id, int n);

    List<Category> getPath(int id);

    List<Category> getPathRelativeTo(int id, int ancestor);

    int getLevel(int id);

    void moveTo(int id, int target);

    void moveTreeTo(int id, int target);

    void deleteAndMove(int id);

    void deleteByIdAllTree(int id);

    Category selectRoot();

    List<Category> selectAllTable(CategoryParam categoryParam);
}