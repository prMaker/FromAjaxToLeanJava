package com.kaishengit.controller;

import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.pojo.SearchParam;
import com.kaishengit.service.BookService;
import com.kaishengit.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping
    public String list(Model model, @RequestParam(name = "p",required = false,defaultValue = "1") Integer pageNo, HttpServletRequest request){
        List<SearchParam> searchParamList = SearchParam.builderSearchParam(request);

        Page<Book> bookPage = null;

        if(searchParamList != null){
            bookPage = bookService.findByPageNoByParam(pageNo,searchParamList);
        }else{
            bookPage = bookService.findByPageNo(pageNo);
        }


        List<BookType> bookTypeList = bookService.findAllType();
        List<Publisher> publisherList = bookService.findAllPublilsher();
        model.addAttribute("bookTypeList",bookTypeList);
        model.addAttribute("publisherList",publisherList);

        model.addAttribute("bookPage",bookPage);
        return "book/list";
    }

    @RequestMapping(value = "/new")
    public String booknew(Model model){
        List<BookType> bookTypeList = bookService.findAllType();
        List<Publisher> publisherList = bookService.findAllPublilsher();
        model.addAttribute("bookTypeList",bookTypeList);
        model.addAttribute("publisherList",publisherList);
        return "book/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String save(Book book){
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/{id:\\d+}/edit")
    public String bookEdit(@PathVariable Integer id,Model model){
        List<BookType> bookTypeList = bookService.findAllType();
        List<Publisher> publisherList = bookService.findAllPublilsher();
        model.addAttribute("bookTypeList",bookTypeList);
        model.addAttribute("publisherList",publisherList);

        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);

        return "book/edit";
    }

    @RequestMapping(value = "/{id:\\d+}/edit",method = RequestMethod.POST)
    public String edit(Book book){
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/{id:\\d+}/del")
    public String del(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("success","删除成功");
        return "redirect:/book";
    }


}
