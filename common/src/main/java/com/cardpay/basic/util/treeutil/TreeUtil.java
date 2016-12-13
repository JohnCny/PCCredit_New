package com.cardpay.basic.util.treeutil;

import com.cardpay.basic.util.ListSortUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 组装树型数据工具,需要继承Tree接口
 *
 * @param <T>  需要组装的Bean类型
 * @param <PK> 主键类型
 *             <p>
 *             Created by yanwe on 2016/12/9.
 */
public class TreeUtil<T extends Tree, PK> {

    private List<T> returnList = new ArrayList<>();

    private boolean order;

    /**
     * 需要排序的属性名
     */
    private String orderKey;

    /**
     * 正序还是倒序 0正序 1倒序
     */
    private int sortMode;

    public final static int ASC = 0;//正序

    public final static int DESC = 1;//倒序

    public TreeUtil() {
    }

    public TreeUtil(String orderKey, int sortMode) {
        this.order = true;
        this.orderKey = orderKey;
        this.sortMode = sortMode;
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param sourceList 数据源
     * @param sourceList 父id
     * @return 层级结果
     */
    public List<T> getChildNodesByParentId(List<T> sourceList, PK parentId) {
        if (sourceList == null || sourceList.isEmpty() || parentId == null) {
            throw new IllegalArgumentException("sourceList is Null or Empty or parentId is Null");
        }
        for (T node : sourceList) {
            //遍历所有的父节点下的所有子节点
            if (node.getParentId().equals(parentId)) {
                recursion(sourceList, node);
                returnList.add(node);
            }
        }
        return returnList;
    }

    /**
     * 根据节点的ID获取所有子节点
     *
     * @param sourceList 数据源
     * @param topId      根Id
     * @return 层级结果
     */
    public List<T> getChildNodesByTopId(List<T> sourceList, PK topId) {
        if (sourceList == null || sourceList.isEmpty() || topId == null) {
            throw new IllegalArgumentException("sourceList is Null or Empty or topId is Null");
        }
        for (T node : sourceList) {
            //遍历所有的父节点下的所有子节点
            node.getParentId();
            if (node.getId() == topId) {
                recursion(sourceList, node);
                returnList.add(node);
            }
        }
        return returnList;
    }

    private void recursion(List<T> sourceList, T node) {
        List<T> childList = getChildList(sourceList, node);//得到子节点列表
        if (order && childList != null && !childList.isEmpty()) {
            ListSortUtil.sortMap(childList, orderKey, sortMode);
        }
        if (hasChild(sourceList, node)) {//判断是否有子节点
            node.setChild(childList);
            for (T childNode : childList) {
                recursion(sourceList, childNode);
            }
        } else {
            node.setChild(childList);
        }
    }

    //得到子节点列表
    private List<T> getChildList(List<T> list, T node) {
        List<T> nodeList = new ArrayList<>();
        for (T childNode : list) {
            if (childNode.getParentId() == node.getId()) {
                nodeList.add(childNode);
            }
        }
        return nodeList;
    }

    // 判断是否有子节点
    private boolean hasChild(List<T> list, T node) {
        return getChildList(list, node).size() > 0 ? true : false;
    }

}