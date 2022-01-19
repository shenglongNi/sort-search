package com.nsl.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ni
 * @date 2022-01-19 16:20
 * @description
 */
public class SysMenu {

    private Integer id;
    private String label;
    private Integer orderNum;
    private Integer parentId;
    private List<SysMenu> children = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public void addChildren(SysMenu child){
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", orderNum=" + orderNum +
                ", parentId=" + parentId +
                '}';
    }
}
