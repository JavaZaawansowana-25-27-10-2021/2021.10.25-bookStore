package com.comarch.book.store.controllers;

import com.comarch.book.store.dao.IBookDAO;
import com.comarch.book.store.dao.IOrderJPADOA;
import com.comarch.book.store.model.Book;
import com.comarch.book.store.model.Order;
import com.comarch.book.store.model.User;
import com.comarch.book.store.services.IOrderService;
import com.comarch.book.store.services.impl.AuthenticationService;
import com.comarch.book.store.services.impl.BookService;
import com.comarch.book.store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class CommonController {

    @Autowired
    BookService bookService;

    @Value("${jakie.moje.ustawienie}")
    String mojeUstawienie;
    private final static String BOOK_CLASS2 = Book.class.getCanonicalName();

    @Autowired
    AuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @Autowired
    IBookDAO bookDAO;

    @Autowired
    IOrderService orderService;

    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    public String main2() {
        System.out.println(BOOK_CLASS2);
        System.out.println(mojeUstawienie);
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        if(this.sessionObject.isLogged()) {
            List<Book> books = this.bookService.getAllBooks();
            model.addAttribute("books", books);
        }

        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authenticate(@RequestParam String login, @RequestParam String password) {
        /*boolean authSuccess = this.authenticationService.authenticate(login, password);
        if(authSuccess) {
            return "redirect:/main";
        } else {
            return "login";
        }*/

        return "";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String requestParams(@RequestParam("a") String zmienna, @RequestParam String b) {
        System.out.println(zmienna);
        System.out.println(b);

        return "redirect:/login";
    }

    @RequestMapping(value = "/test/{id5}/{name}")
    public String pathVariable(@PathVariable("id5") String id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "redirect:/";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String headers(@RequestHeader String jakis) {
        System.out.println(jakis);
        return "redirect:/";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public String login2(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String authenticate2(@ModelAttribute User user) {
        this.authenticationService.authenticate(user.getLogin(), user.getPassword());
        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        } else {
            return "redirect:/login2";
        }
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String test3(@RequestHeader Map<String, String> headers) {
        for(Map.Entry<String, String> entry : headers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET)
    public String test4() {
        Book book = new Book("title", "author", 100.0, "isbn");
        book.setId(20);

        this.bookDAO.persistBook(book);

        return "redirect:/main";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        Order order = new Order();

        List<Book> allBooks = this.bookService.getAllBooks();
        Set<Book> books = new HashSet<>(allBooks);
        books.add(new Book("String title", "String author", 10.0, "String isbn"));
        order.setBookSet(books);

        order.setUser(this.sessionObject.getUser());

        order.setDate(new Date());

        this.orderService.saveOrder(order);

        return "redirect:/main";
    }

    @RequestMapping(value = "book1", method = RequestMethod.GET)
    public String book() {
        List<Book> books = this.bookDAO.getAllBooks();
        System.out.println(books);

        return "redirect:/";
    }
}
