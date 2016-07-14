package com.kaishengit.service;

import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.util.PinYin;
import com.kaishengit.util.ShiroUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/13.
 */
@Named
public class CustomerService {

    @Inject
    private CustomerMapper customerMapper;

    public List<Customer> findCustomerByParam(Map<String, Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.findAllCustomerByParam(param);
        }
        return customerMapper.findByParam(param);
    }

    public Long countAllByParam(Map<String,Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.countAll();
        }
        return customerMapper.countAllByParam(param);
    }

    public Long countByParam(Map<String, Object> param) {
        if(ShiroUtil.getCurrentUserType().equals("经理")){
            return customerMapper.countByDirectorParam(param);
        }
        return customerMapper.countByParam(param);
    }

    public List<Customer> findAllCompany() {
        return customerMapper.findByType(Customer.TYPE_COMPANY);
    }

    @Transactional
    public void save(Customer customer) {
        if(customer.getCompanyid() != null){
            customer.setCompanyname(customerMapper.findById(customer.getCompanyid()).getName());
        }
        customer.setPinyin(PinYin.toPinYin(customer.getName()));
        customer.setUserid(ShiroUtil.getCurrentUserID());
        customerMapper.save(customer);
    }

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

    public Customer findById(Integer id) {
        return customerMapper.findById(id);
    }

    @Transactional
    public void update(Customer customer) {
        customer.setPinyin(PinYin.toPinYin(customer.getName()));
        if(customer.getCompanyid() != null){
            customer.setCompanyname(customerMapper.findById(customer.getCompanyid()).getName());
        }
        customerMapper.update(customer);
    }
}
