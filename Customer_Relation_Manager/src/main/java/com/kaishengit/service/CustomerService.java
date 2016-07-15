package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.google.zxing.EncodeHintType;
import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.User;
import com.kaishengit.util.PinYin;
import com.kaishengit.util.ShiroUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/13.
 */
@Named
public class CustomerService {

    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private UserMapper userMapper;

    /**
     * 根据参数获取所有客户列表
     * @param param
     * @return
     */
    public List<Customer> findCustomerByParam(Map<String, Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.findAllCustomerByParam(param);
        }
        return customerMapper.findByParam(param);
    }

    /**
     * 该用户所有客户数量
     * @param param
     * @return
     */
    public Long countAllByParam(Map<String,Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.countAll();
        }
        return customerMapper.countAllByParam(param);
    }

    /**
     * 该客户筛选出来的客户数量
     * @param param
     * @return
     */
    public Long countByParam(Map<String, Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.countByDirectorParam(param);
        }
        return customerMapper.countByParam(param);
    }

    /**
     * 查询出所有公司
     * @return
     */
    public List<Customer> findAllCompany() {
        return customerMapper.findByType(Customer.TYPE_COMPANY);
    }

    /**
     * 保存新客户
     * @param customer
     */
    @Transactional
    public void save(Customer customer) {
        if(customer.getCompanyid() != null){
            customer.setCompanyname(customerMapper.findById(customer.getCompanyid()).getName());
        }
        customer.setPinyin(PinYin.toPinYin(customer.getName()));
        customer.setUserid(ShiroUtil.getCurrentUserID());
        customerMapper.save(customer);
    }

    /**
     * 删除客户
     * @param id
     */
    @Transactional
    public void del(Integer id) {
        Customer customer = customerMapper.findById(id);
        if(customer.getType().equals(Customer.TYPE_COMPANY)){
            List<Customer> customerList = customerMapper.findAllByCompanyId(id);
            for(Customer cust : customerList){
                cust.setCompanyname(null);
                cust.setCompanyid(null);
                customerMapper.update(cust);
            }
        }
//        TODO 删除该对象对应的项目管理
//        TODO 删除该对象对应的代办事项

        customerMapper.del(id);
    }

    /**
     * 根据id查找客户
     * @param id
     * @return
     */
    public Customer findById(Integer id) {
        Customer customer = customerMapper.findById(id);
//        TODO 思考一下一段是否添加
//        if(ShiroUtil.getCurrentUserID() != customer.getUserid()
//                && !ShiroUtil.isManager()){
//            throw new NotFoundException();
//        }
        return customer;
    }

    /**
     * 更新客户
     * @param customer
     */
    @Transactional
    public void update(Customer customer) {
        customer.setPinyin(PinYin.toPinYin(customer.getName()));
        if(customer.getCompanyid() != null){
            customer.setCompanyname(customerMapper.findById(customer.getCompanyid()).getName());
        }
        customerMapper.update(customer);
    }

    /**
     * 公开客户
     * @param id
     */
    @Transactional
    public void openCustomer(Integer id) {
        Customer customer = customerMapper.findById(id);
//        if(!ShiroUtil.getCurrentUserID().equals(customer.getUserid())
//        && customer.getUserid() != null
        if(ShiroUtil.getCurrentUserID() != customer.getUserid()
                && !ShiroUtil.isManager()){
            throw new NotFoundException();
        }
        customer.setUserid(null);
        customerMapper.update(customer);
    }

    /**
     * 转移客户
     * @param id
     * @param userid
     */
    @Transactional
    public void moveCustomer(Integer id, Integer userid) {
        Customer customer = customerMapper.findById(id);

        if(customer == null){
            throw new NotFoundException();
        }

//        if(customer.getUserid() == null&&
//                !ShiroUtil.getCurrentUserID().equals(customer.getUserid())
        if(customer.getUserid() != ShiroUtil.getCurrentUserID()
                && !ShiroUtil.isManager()){
            throw new ForbiddenException();
        }
        customer.setUserid(userid);
        customerMapper.update(customer);
    }

    /**
     * 查找所有员工
     * @return
     */
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    /**
     * 根据公司id查找公司员工
     * @param id
     * @return
     */
    public List<Customer> findAllCustomerByCompanyId(Integer id) {
        return customerMapper.findAllByCompanyId(id);
    }

    /**
     * 制作mecard
     * @param id
     * @return
     */
    public StringBuilder makeMecard(Integer id){
//        Hashtable hints = new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");

        StringBuilder mecard = new StringBuilder();
        Customer customer = customerMapper.findById(id);
        if(customer != null){

            mecard.append("MECARD:N:");
            mecard.append(customer.getName());
            if(customer.getCompanyid() != null){
                mecard.append(";ORG:");
                mecard.append(customer.getCompanyname());
            }
            mecard.append(";TEL:");
            mecard.append(customer.getTel());
            if(customer.getEmail() != null) {
                mecard.append(";EMAIL:");
                mecard.append(customer.getEmail());
            }
            if(customer.getAddress() != null) {
                mecard.append(";ADR:");
                mecard.append(customer.getAddress());
            }
        }

        return mecard;
    }
}
