package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.mapper.RoleMapper;
import com.kaishengit.mapper.UserLogMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Role;
import com.kaishengit.pojo.User;
import com.kaishengit.pojo.UserLog;
import com.kaishengit.util.ShiroUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class UserService {

    @Inject
    private UserMapper userMapper;
    @Inject
    private UserLogMapper userLogMapper;
    @Inject
    private RoleMapper roleMapper;

    /**
     * 创建用户的登录日志
     * @param ip
     */
    public void saveUserLogin(String ip) {
        UserLog userLog = new UserLog();
        userLog.setLoginip(ip);
        userLog.setLogintime(DateTime.now().toString("yyyy-MM-dd HH:mm"));
        userLog.setUserid(ShiroUtil.getCurrentUserID());

        userLogMapper.save(userLog);
    }

    /**
     * 修改用户密码
     * @param password
     */
    public void changePassword(String password) {
        User user = ShiroUtil.getCurrentUser();
        user.setPassword(DigestUtils.md5Hex(password));

        userMapper.updateUser(user);
    }

    /**
     * 获取当前登录用户的登录日志
     * @param start
     * @param length
     * @return
     */
    public List<UserLog> findCurrentUserLog(String start, String length) {
        Map<String,Object> param = Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserID());
        param.put("start",start);
        param.put("length",length);
        return userLogMapper.findByParam(param);
    }


    /**
     * 获取当前用户日志数量
     * @return
     */
    public Long findCurrentUserLogCount() {
        Map<String,Object> param = Maps.newHashMap();
        param.put("userId",ShiroUtil.getCurrentUserID());
        return userLogMapper.countByParam(param);
    }

    /**
     * 根据当前参数查询用户列表
     * @param keyword
     * @param start
     * @param length
     * @return
     */
    public List<User> findUserByParam(String keyword, String start, String length) {
        return userMapper.findUserByParam(keyword,start,length);
    }

    /**
     * 查询总数量
     * @return
     */
    public Long countTotal() {
        return userMapper.countUserTotal();
    }

    /**
     * 根据当前参数查询用户数量
     * @param keyword
     * @return
     */
    public Long countParam(String keyword) {
        return userMapper.countUserParam(keyword);
    }

    /**
     * 查找所有角色
     * @return
     */
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    /**
     * 保存新用户
     * @param user
     */
    @Transactional
    public void saveUser(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setEnable(true);
        userMapper.save(user);
        //TODO 向公众平台注册账号
    }

    /**
     * 查看用户名是否可用
     * @param username
     * @return
     */
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 重置密码
     * @param id
     */
    public void resetPassword(Integer id) {
        User user = userMapper.findById(id);
        if(user!=null){
            user.setPassword(DigestUtils.md5Hex("000000"));
            userMapper.updateUser(user);
        }
    }

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 编辑用户
     * @param user
     */
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
