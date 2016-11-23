package com.cardpay.basic.base.model;

/**
 * Created by chenkai on 2016/11/23.
 */
public class EchatesModel {


    public EchatesModel(String name, Integer value){
        this.name = name;
        this.value = value;
    }


    private String name;

    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
