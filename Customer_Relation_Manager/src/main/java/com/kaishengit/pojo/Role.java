package com.kaishengit.pojo;

import java.io.Serializable;

public class Role implements Serializable {

    public static final String ROLENAME_ADMIN = "管理员";
    public static final String ROLENAME_EMPLOYEE="员工";
    public static final String ROLENAME_MANAGER="经理";

    private Integer id;
    private String rolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
