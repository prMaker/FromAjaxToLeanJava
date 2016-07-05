package com.kaishengit.controller;

import com.kaishengit.exception.DataNotFoundException;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String saveBook(Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","操作成功！");
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/del",method = RequestMethod.GET)
    public String delBook(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","删除成功");
        bookService.delById(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id,Model model){
        Book book = bookService.findById(id);
        if(book == null){
            throw new DataNotFoundException();
        }

        model.addAttribute("publisherList",bookService.findAllPublishers());
        model.addAttribute("bookTypeList",bookService.findAllBookTypes());
        model.addAttribute("book",book);
        return "books/edit";
    }

    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.POST)
    public String editBook(Book book,RedirectAttributes redirectAttributes ){
        bookService.update(book);
        redirectAttributes.addFlashAttribute("message","修改成功！");
        return "redirect:/books";
    }











}
