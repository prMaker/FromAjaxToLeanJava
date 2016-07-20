package com.kaishengit.service;

import com.google.common.collect.Maps;
import com.kaishengit.exception.ForbiddenException;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.mapper.SalesFileMapper;
import com.kaishengit.mapper.SalesLogMapper;
import com.kaishengit.mapper.SalesMapper;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesLog;
import com.kaishengit.util.ShiroUtil;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/15.
 */
@Named
public class SalesService {

    @Inject
    private SalesMapper salesMapper;
    @Inject
    private CustomerMapper customerMapper;
    @Inject
    private SalesLogMapper salesLogMapper;
    @Inject
    private SalesFileMapper salesFileMapper;

    public List<Customer> getAllCustomer() {
        return customerMapper.findAllCustomer();
    }

    /**
     * 根据搜索参数参数查找dataTable数据
     * @param param
     * @return
     */
    public List<Sales> findAllSalesByParam(Map<String,Object> param) {
        return salesMapper.findAllByParam(param);
    }

    /**
     * 根据用户查找各自的所有用户数量
     * @return
     */
    public Long coungAll() {
        Map<String,Object> param = Maps.newHashMap();
        if(ShiroUtil.isEmployee()){
            param.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(param);
    }

    /**
     * 根据查询条件筛选查找的数量
     * @param param
     * @return
     */
    public Long countFilterByparam(Map<String, Object> param) {
        if(ShiroUtil.isEmployee()){
            param.put("userid",ShiroUtil.getCurrentUserID());
        }
        return salesMapper.countByParam(param);
    }

    /**
     * 保存新建客户
     * @param sales
     */
    @Transactional
    public void save(Sales sales) {
        sales.setUserId(ShiroUtil.getCurrentUserID());
        sales.setUsername(ShiroUtil.getCurrentUserName());
        Customer customer = customerMapper.findById(sales.getCustomerid());
        if(customer == null){
            throw new NotFoundException();
        }
//        保存跟进记录
        sales.setCustomername(customer.getName());
        sales.setLasttime(DateTime.now().toString("YYYY-MM-dd HH:mm:ss"));
        salesMapper.save(sales);

        SalesLog salesLog = new SalesLog();
        salesLog.setType(SalesLog.TYPE_AUTO);
        salesLog.setContext(ShiroUtil.getCurrentUserName()+"创建了该机会");
        salesLog.setSalesid(sales.getId());
        salesLogMapper.save(salesLog);
    }

    /**
     * 修改进度
     * @param id
     * @param progress
     */
    @Transactional
    public void editProgress(Integer id, String progress) {
        Sales sales = salesMapper.findById(id);
        if(sales == null){
            throw new NotFoundException();
        }
        if(sales.getUserId() != ShiroUtil.getCurrentUserID()
                && !ShiroUtil.isManager()){
            throw new NotFoundException();
        }
        if(!Sales.getProgressList().contains(progress)){
            throw new NotFoundException();
        }

//        TODO 添加完成交易事件记录
//        TODO 添加销售机会关联页面

        sales.setProgress(progress);
        sales.setLasttime(DateTime.now().toString("YYYY-MM-dd HH:mm:ss"));
        salesMapper.update(sales);

        SalesLog salesLog = new SalesLog();
        salesLog.setSalesid(id);
        salesLog.setContext("将当前进度修改为"+progress);
        salesLog.setType(SalesLog.TYPE_AUTO);
        salesLogMapper.save(salesLog);
    }

    /**
     * 删除销售机会
     * @param id
     */
    @Transactional
    public void delSales(Integer id) {
        Sales sales = salesMapper.findById(id);
        if(sales == null){
            throw new NotFoundException();
        }
        salesLogMapper.delBySalesId(id);
//        TODO 删除上传的文件
        salesMapper.delSales(id);
    }

    /**
     * 获取跟进记录列表
     * @param saleId
     * @return
     */
    public List<SalesLog> findAllSalesLogBySalesid(Integer saleId) {
        return salesLogMapper.findBySalesid(saleId);
    }

    public Sales findById(Integer id) {
        return salesMapper.findById(id);
    }

    /**
     * 手动修改跟进记录
     * @param salesLog
     */
    public void saveSalesLog(SalesLog salesLog) {
        Sales sales = salesMapper.findById(salesLog.getSalesid());
        if(sales.getUserId() != ShiroUtil.getCurrentUserID()
                && !ShiroUtil.isManager()){
            throw new ForbiddenException();
        }
        salesLog.setType(SalesLog.TYPT_HAND);
        salesLogMapper.save(salesLog);

        sales.setLasttime(DateTime.now().toString("YYYY-MM-dd HH:mm"));
        salesMapper.update(sales);
    }
}
