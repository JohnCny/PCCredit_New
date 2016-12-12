package com.cardpay.basic.util.treeutil;

import java.util.List;

/**
 * 遍历层级需要的接口
 *
 * Created by yanwe on 2016/12/9.
 */
public interface Tree<PK,T extends Tree> {

    PK getId();

    PK getParentId();

    void setChild(List<T> child);
}
