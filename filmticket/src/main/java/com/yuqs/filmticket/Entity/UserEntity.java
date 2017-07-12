package com.yuqs.filmticket.Entity;

import java.io.Serializable;

/**
 * 用户实体类  实现Serializable使其能被intent传输
 */

public class UserEntity implements Serializable{
    private String userName,password,name;

    public UserEntity() {
    }

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
