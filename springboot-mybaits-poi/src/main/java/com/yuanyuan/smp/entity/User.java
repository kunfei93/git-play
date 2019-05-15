package com.yuanyuan.smp.entity;

import java.io.Serializable;

public class User implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 2895782870082326368L;

    private Integer userId;

    private String name;

    private Integer age;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
