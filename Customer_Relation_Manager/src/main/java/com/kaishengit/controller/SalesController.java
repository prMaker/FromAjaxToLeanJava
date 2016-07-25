package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.dto.JSONResult;
import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Customer;
import com.kaishengit.pojo.Sales;
import com.kaishengit.pojo.SalesLog;
import com.kaishengit.pojo.Task;
import com.kaishengit.service.SalesService;
import com.kaishengit.service.TaskService;
import com.kaishengit.util.ShiroUtil;
import com.kaishengit.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/15.
 */
@Controller
@RequestMapping("/sales")
public class SalesController {

    @Inject
    private SalesService salesService;
    @Inject
    private TaskService taskService;

    @RequestMapping()
    public String sales(Model model){
        List<Customer> customerList = salesService.getAllCustomer();
        model.addAttribute("customerList",customerList);
        return "sales/list";
    }

    /**
     * Ajax获取销售机会列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/data/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult<Sales> dataLoad(HttpServletRequest request){
        String name = request.getParameter("name");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String progress = request.getParameter("progress");

        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        Map<String,Object> param = Maps.newHashMap();
        param.put("name", Strings.toUTF8(name));
        param.put("startTime",startTime);
        param.put("endTime",endTime);
        param.put("progress",Strings.toUTF8(progress));
        param.put("start",start);
        param.put("length",length);

        if(ShiroUtil.isEmployee()){
            param.put("userid",ShiroUtil.getCurrentUserID());
        }

        List<Sales> salesList = salesService.findAllSalesByParam(param);
        Long countAll = salesService.coungAll();
        Long countFilter = salesService.countFilterByparam(param);

        return new DataTablesResult<>(draw,salesList,countAll,countFilter);
    }

    /**
     * 保存新的销售机会
     * @param sales
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public String salesNew(Sales sales){
        salesService.save(sales);
        return "success";
    }


    /**
     * 进入单个Sale界面
     */
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String sale(@PathVariable Integer id,Model model){
        List<SalesLog> salesLogList = salesService.findAllSalesLogBySalesid(id);
        if(salesLogList == null){
            throw new  NotFoundException();
        }
        for(SalesLog salesLog :salesLogList){
            System.out.println(salesLog);
        }
        Sales sales = salesService.findById(id);
        List<Task> taskList = taskService.findallBySalesid(id);
        model.addAttribute("taskList",taskList);
        model.addAttribute("sales",sales);
        model.addAttribute("salesLogList",salesLogList);
        return "sales/sale";
    }

    /**
     * 获取id的task
     * @param id
     * @return
     */
    @RequestMapping(value = "/task/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public JSONResult taskLoad(@PathVariable Integer id){
        Task task = taskService.findById(id);
        if(task == null){
            throw new NotFoundException();
        }
        return new JSONResult(task);
    }

    /**
     * 修改进度
     * @return
     */
    @RequestMapping(value = "/progress/edit",method = RequestMethod.POST)
    public String progressEdit(Integer id,String progress){
        salesService.editProgress(id,progress);
        return "redirect:/sales/"+id;
    }

    /**
     * 删除销售机会
     * @param id
     * @return
     */
    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public String delSales(@PathVariable Integer id){
        salesService.delSales(id);
        return "success";
    }

    /**
     * 新建新的跟进记录
     * @param salesLog
     * @return
     */
    @RequestMapping(value = "/log/new",method = RequestMethod.POST)
    public String newSalesLog(SalesLog salesLog){
        salesService.saveSalesLog(salesLog);
        return "redirect:/sales/"+salesLog.getSalesid();
    }












}
