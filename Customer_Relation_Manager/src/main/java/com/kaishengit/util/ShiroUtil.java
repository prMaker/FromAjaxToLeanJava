package com.kaishengit.util;

import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static User getCurrentUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getCurrentUserID() {
        return getCurrentUser().getId();
    }

    public static String getCurrentUserName() {
        return getCurrentUser().getUsername();
    }

    public static String getCurrentUserRealname() {
        return getCurrentUser().getRealname();
    }

    public static Integer getCurrentUserRoleId() {
        return getCurrentUser().getRoleid();
    }

    public static String getCurrentUserType() {
        return getCurrentUser().getRole().getRolename();
    }

    public static Boolean isEmployee(){
        return getCurrentUserRealname().equals(Role.ROLENAME_EMPLOYEE);
    }

    public static Boolean isManager(){
        return getCurrentUserRealname().equals(Role.ROLENAME_MANAGER);
    }
}
