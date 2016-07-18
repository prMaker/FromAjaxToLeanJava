package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.dto.JSONResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.User;
import com.kaishengit.service.CustomerService;
import com.kaishengit.util.ShiroUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/13.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * customer列表页面显示
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String customer(Model model){
//        List<Customer> customerList = customerService.findAllCompany();
//        model.addAttribute("customerList",customerList);
        return "customer/list";
    }

    /**
     * customerAjax获取客户数据列表显示
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<Customer> customerResult(HttpServletRequest request, Model model){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");

        Map<String,Object> param = Maps.newHashMap();
        param.put("start",start);
        param.put("length",length);
        param.put("keyword",keyword);
        param.put("userid",ShiroUtil.getCurrentUserID());

        List<Customer> customerList = customerService.findCustomerByParam(param);
        Long countAll = customerService.countAllByParam(param);
        Long countParam = customerService.countByParam(param);

        return new DataTablesResult<>(draw,customerList,countAll,countParam);
    }

    /**
     * 添加新客户
     * @param customer
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public String customerNew(Customer customer){
        customerService.save(customer);
        return "success";
    }

    /**
     * 删除客户
     */
    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String del(@PathVariable Integer id){
        customerService.del(id);
        return "success";
    }

    /**
     * Ajax获取公司列表
     */
    @RequestMapping(value = "/companyList/load.json",method = RequestMethod.GET)
    @ResponseBody
    public JSONResult companyList(){
        List<Customer> customerList = customerService.findAllCompany();
        JSONResult result = new JSONResult(JSONResult.SUCCESS,customerList);
        return result;
    }

    /**
     * 修改客户前资料上传
     */
    @RequestMapping(value = "/edit/load/{id:\\d+}.json",method = RequestMethod.GET)
    @ResponseBody
    public JSONResult editDataLoad(@PathVariable Integer id){
        List<Customer> customerList = customerService.findAllCompany();
        Customer customer = customerService.findById(id);
        if(customer == null){
            return new JSONResult(JSONResult.ERROR,"没有找到该客户");
        }

        Map<String,Object> result = Maps.newHashMap();
        result.put("customer",customer);
        result.put("customerList",customerList);
        return new JSONResult(JSONResult.SUCCESS,result);
    }

    /**
     * 修改客户
     * @param customer
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public String editForm(Customer customer){
        customerService.update(customer);
        return "success";
    }

    /**
     * 到达客户资料界面，查找所有员工，及该客户资料
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id:\\d+}")
    public String customer(@PathVariable Integer id,Model model){
        List<User> userList = customerService.findAllUser();
        Customer customer = customerService.findById(id);
        if(customer == null){
            return "error/403";
        }
        if(ShiroUtil.getCurrentUserID() != customer.getUserid()
                && !ShiroUtil.isManager()){
            throw new NotFoundException();
        }
        if(customer.getType().equals(Customer.TYPE_COMPANY)){
            List<Customer> customerList = customerService.findAllCustomerByCompanyId(customer.getId());
            model.addAttribute("customerList",customerList);
        }
        model.addAttribute("customer",customer);
        model.addAttribute("userList",userList);
        return "customer/cust";
    }

    /**
     * 获取客户二维码资料
     */
    @RequestMapping(value = "/qrcode/{id:\\d+}.png",method = RequestMethod.GET)
    public void getQrCode(@PathVariable Integer id, HttpServletResponse response) throws WriterException, IOException {
        String mecard = customerService.makeMecard(id).toString();

        Map<EncodeHintType,Object> hints = Maps.newHashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");

        BitMatrix bitMatrix = new MultiFormatWriter().encode(mecard,BarcodeFormat.QR_CODE,300,300,hints);
        OutputStream outputStream = response.getOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix,"png",outputStream);
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 公开客户
     * @param id
     * @return
     */
    @RequestMapping(value = "/open/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String openCustomer(@PathVariable Integer id){
        customerService.openCustomer(id);
        return "success";
    }

    /**
     * POST转移客户
     * @param id
     * @param userid
     * @return
     */
    @RequestMapping(value = "/move",method = RequestMethod.POST)
    @ResponseBody
    public String moveCustomer(Integer id,Integer userid){
        customerService.moveCustomer(id,userid);
        return "success";
    }













}
