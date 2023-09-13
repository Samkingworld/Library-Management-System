package com.samkingworld.librarySystem.controller;

import com.samkingworld.librarySystem.model.Book;
import com.samkingworld.librarySystem.model.BorrowedBook;
import com.samkingworld.librarySystem.service.BookService;
import com.samkingworld.librarySystem.service.BorrowedBookService;
import com.samkingworld.librarySystem.utils.UpdateReqest;
import com.samkingworld.librarySystem.model.User;
import com.samkingworld.librarySystem.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Controller {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowedBookService borrowedBookService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/id/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/userId")
    public User getUserByUserId(@RequestParam(name = "id") String userId){
        try {
            return userService.getUserByUserId(userId);
        }catch (Exception e){
            return new User();
        }
    }


    @PostMapping("/user/add")
    public String createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }
    @DeleteMapping("/user/Id/{id}")
    public String deleteUserById(@PathVariable Long id){return userService.deleteUserById(id);}

    @DeleteMapping("/user/userId/{user_id}")
    public String deleteUserByUserId(@PathVariable String user_id){return userService.deleteUserByUserId(user_id);}

    @DeleteMapping("/user/email/{email}")
    public String deleteUserByEmail(@PathVariable String email){return userService.deleteUserByEmail(email);}


    @PutMapping("/user/update/{user_id}")
    public User updateUser( @PathVariable String user_id, @RequestBody @Valid UpdateReqest updateReqest){
        return userService.updateUser(user_id, updateReqest);
    }

    //BOOKS
    @GetMapping("/books")
    public List<Book> getAllBooks(){return bookService.getAllBooks();};
    @GetMapping("/book/byIsbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){return bookService.getBookByIsbn(isbn);};
    @GetMapping("/book/byAuthor/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){return bookService.getBookByAuthor(author);};
    @GetMapping("/book/byTitle/{title}")
    public Book getBookByTitle(@PathVariable String title){return bookService.getBookByTitle(title);};
    @PostMapping("/book/add")
    public Book addBook(@RequestBody @Valid Book book){return bookService.addBook(book);}
    @PostMapping("/book/borrow")
    public String borrowBook(@Valid @RequestBody BorrowedBook request){return bookService.borrowBook(request);};
    @DeleteMapping("book/byIsbn/{isbn}")
    public String deleteBookByIsbn(@PathVariable String isbn){return bookService.deleteBookByIsbn(isbn);};
    @DeleteMapping("/book/byBookId/{bookId}")
    public String deleteBookById(@PathVariable Long bookId){return bookService.deleteBookById(bookId); };


    //Borrowed Book
    @GetMapping("/borrowedBooks/userId")
    public List<BorrowedBook> getBorrowedBookByUserId(@RequestParam(name = "user_id") String userId){
        try {
            return borrowedBookService.getBorrowedBookByUserId(userId);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
    @GetMapping("/borrowedBooks")
    public List<BorrowedBook> getAllBorrowedBooks(){return borrowedBookService.getAllBorrowedBooks();}

    @PutMapping("/borrowedBooks/return/{isbn}")
    public String returnBook(String isbn){return borrowedBookService.returnBook(isbn);};



}
