package com.kaishengit.controller;


import com.google.common.collect.Maps;
import com.kaishengit.pojo.Book;
import com.kaishengit.service.BookService;
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
 * Created by Administrator on 2016/7/6.
 */
@Controller
@RequestMapping("/datatable")
public class DataTableController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String table(Model model){
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList",bookList);
        model.addAttribute("pubs",bookService.findAllPublishers());
        model.addAttribute("types",bookService.findAllBookTypes());
        return "datatable/datatable";
    }

    @RequestMapping(value = "/data.json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> load(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String keyword = request.getParameter("search[value]");
        String sortColumnIndex = request.getParameter("order[0][column]");
        String sortColumnName = request.getParameter("columns["+sortColumnIndex+"][name]");
        String sortType = request.getParameter("order[0][dir]");
        keyword = Strings.toUTF8(keyword);

        Map<String,Object> param = Maps.newHashMap();
        param.put("start",start);
        param.put("length",length);
        param.put("keyword",keyword);
        param.put("sortColumn",sortColumnName);
        param.put("sortType",sortType);

        Map<String,Object> result = Maps.newHashMap();
        result.put("data",bookService.findBookByData(param));
        result.put("draw",draw);
        result.put("recordsTotal",bookService.bookCount().intValue());
        result.put("recordsFiltered",bookService.bookCountByData(param).intValue());

        return result;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public String saveBook(Book book){
        bookService.save(book);
        return "success";
    }

    @RequestMapping(value = "/edit/{id:\\d+}",method = RequestMethod.GET)
    @ResponseBody
    public Book editBook(@PathVariable Integer id){
        return bookService.findById(id);
    }

//    返回值时考虑返回的是什么类型的
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public String editBook(Book book){
        bookService.update(book);
        return "success";
    }

    @RequestMapping(value = "/del/{id:\\d+}",method = RequestMethod.GET)
    public String delBook(@PathVariable Integer id){
        bookService.delById(id);
        return "success";
    }
}
