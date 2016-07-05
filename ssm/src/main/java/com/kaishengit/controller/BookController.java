package com.kaishengit.controller;

import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */

@Controller
@RequestMapping("/books")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String findBook(Model model){
        List<Book> bookList = bookService.list();
        model.addAttribute("bookList",bookList);
        return "books/list";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String saveBook(Model model){
        List<BookType> bookTypes = bookService.findAllBookTypes();
        List<Publisher> publishers = bookService.findAllPublishers();
        System.out.println(publishers);
        model.addAttribute("bookTypeList",bookTypes);
        model.addAttribute("publisherList",publishers);
        return "books/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveBook(Book book){
        bookService.save(book);
        return "redirect:/books";
    }















}
