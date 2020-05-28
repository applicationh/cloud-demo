package com.wsh.usercom.orther;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wsh
 */
public class TreeNode {
    private Integer id;

    private String title;
    /**
     * 节点是否初始展开，默认 false
     */
    private Boolean spread;
    /**
     * 节点是否初始为选中状态（如果开启复选框的话），默认 false
     */
    private Boolean checked;
    /**
     * 节点是否为禁用状态。默认 false
     */
    private Boolean disabled;

    private List<TreeNode> children;

    /** 复选框集合*/
    private String checkArr="0";


    //数据库
    private Integer pid;

    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.parentId = pid;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
