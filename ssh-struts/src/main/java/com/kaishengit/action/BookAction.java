package com.kaishengit.action;

import com.kaishengit.exception.NotFoundException;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.BookType;
import com.kaishengit.pojo.Publisher;
import com.kaishengit.pojo.SearchParam;
import com.kaishengit.service.BookService;
import com.kaishengit.util.Page;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
@Namespace("/book")
public class BookAction extends BaseAction{

    @Inject
    private BookService bookService;

//  TODO   查看出版社无法保留问题

    private List<BookType> bookTypeList;
    private List<Publisher> publisherList;
    private Page<Book> bookPage;
    private Book book;
    private Integer p;
    private SearchParam searchParam;
    private Integer id;

    @Action("list")
    public String list(){

        if(p == null){
            p = 1;
        }

        bookTypeList = bookService.findAllType();
        publisherList = bookService.findAllPublilsher();
        List<SearchParam> searchParamList = SearchParam.builderSearchParam(getHttpServletRequest());
        bookPage = bookService.findByPageNoByParam(p,searchParamList);
        for(SearchParam searchParam : searchParamList){
            System.out.println(searchParam.getValue());
        }

        return SUCCESS;
    }

    @Action("new")
    public String toNew(){
        bookTypeList = bookService.findAllType();
        publisherList = bookService.findAllPublilsher();

        return SUCCESS;
    }


    @Action(value = "save",results = @Result(type = "redirectAction",params = {
            "actionName","list","namespace","/book"
    }))
    public String save(){

        bookService.save(book);
        return SUCCESS;
    }

    @Action(value = "del",results = @Result(type = "redirectAction",params = {
            "actionName","/list","namespace","/book"
    }))
    public String del(){
        bookService.deleteBookById(id);
        return SUCCESS;
    }

    @Action(value = "edit")
    public String edit(){
        book = bookService.findBookById(id);
        if(book == null){
            throw new NotFoundException("未找到该数据");
        }
        bookTypeList = bookService.findAllType();
        publisherList = bookService.findAllPublilsher();

        return SUCCESS;
    }

    @Action(value = "editsave",results = @Result(type = "redirectAction",params = {
            "actionName","list"
    }))
    public String editSave(){
        bookService.save(book);

        return SUCCESS;
    }

    // get set


    public List<BookType> getBookTypeList() {
        return bookTypeList;
    }

    public void setBookTypeList(List<BookType> bookTypeList) {
        this.bookTypeList = bookTypeList;
    }

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public SearchParam getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(SearchParam searchParam) {
        this.searchParam = searchParam;
    }

    public Page<Book> getBookPage() {
        return bookPage;
    }

    public void setBookPage(Page<Book> bookPage) {
        this.bookPage = bookPage;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
