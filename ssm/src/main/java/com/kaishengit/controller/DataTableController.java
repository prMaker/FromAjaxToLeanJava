package com.kaishengit.controller;

import com.kaishengit.pojo.Book;
import com.kaishengit.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@Controller
public class DataTableController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String dataTable(Model model){
        List<Book> bookList = bookService.findBookAll();
        model.addAttribute("bookList",bookList);
        return "datatables/datatable";
    }


}
