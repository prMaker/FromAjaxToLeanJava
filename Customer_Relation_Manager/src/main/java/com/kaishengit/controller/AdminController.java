package com.kaishengit.controller;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.dto.JSONResult;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/7/11.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Inject
    private UserService userService;

    /**
     * 转入用户列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/usermanager",method = RequestMethod.GET)
    public String userMageger(Model model){
        List<Role> roleList = userService.findAllRole();
        model.addAttribute("roleList",roleList);
        return "admin/adminlist";
    }

    /**
     * 新增用户Ajax调用
     * @param user
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String userNew(User user){
        userService.saveUser(user);
        return "success";
    }

    /**
     * 验证用户名是否可用
     * @param username
     * @return
     */
    @RequestMapping(value = "/username",method = RequestMethod.GET)
    @ResponseBody
    public String checkUsername(String username){
        User user = userService.findUserByUsername(username);
        if(user == null){
            return "true";
        }
        return "false";
    }

    /**
     * 传输用户列表信息，Ajax调用
     * @param request
     * @return
     */
    @RequestMapping(value = "/usermanager/data",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<User> userData(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");

        List<User> userList = userService.findUserByParam(keyword,start,length);
        Long countTotal = userService.countTotal();
        Long countParam = userService.countParam(keyword);

        return new DataTablesResult<>(draw,userList,countTotal,countParam);

    }

    /**
     * post方式重置密码
     * @param id
     * @return
     */
    @RequestMapping(value = "/resetpassword",method = RequestMethod.POST)
    @ResponseBody
    public String resetPassword( Integer id){
        userService.resetPassword(id);
        return "success";
    }

    /**
     * post方式显示编辑的用户数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/edit.json",method = RequestMethod.POST)
    @ResponseBody
    public JSONResult editUserLoad(Integer id){
        User user = userService.findUserById(id);
        if(user == null){
            return new JSONResult("没有ID为"+id+"的用户资料");
        }
        return new JSONResult(user);
    }

    /**
     * 获取修改用户表单的值传入modal中
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/edit/{id:\\d+}.json",method = RequestMethod.GET)
    @ResponseBody
    public JSONResult editUsersDataLoad(@PathVariable Integer id){
        User user = userService.findUserById(id);
        if(user == null){
            return new JSONResult("没有ID为"+id+"的用户资料");
        }
        return new JSONResult(user);
    }

    /**
     * 编辑用户
     * @return
     */
    @RequestMapping(value = "/users/edit",method = RequestMethod.POST)
    @ResponseBody
    public String editUser(User user){
        userService.updateUser(user);
        return "success";
    }

}
