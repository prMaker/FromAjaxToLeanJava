package com.kaishengit.mapper;

import com.kaishengit.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/13.
 */
public interface CustomerMapper {
    List<Customer> findByParam(Map<String, Object> param);

    Long countAllByParam(Map<String,Object> param);

    Long countByParam(Map<String, Object> param);

    List<Customer> findByType(String company);

    void save(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAllCustomerByParam(Map<String, Object> param);

    Long countAll();

    Long countByDirectorParam(Map<String, Object> param);

    List<Customer> findAllByCompanyId(Integer id);

    void update(Customer cust);

    void del(Integer id);
}
