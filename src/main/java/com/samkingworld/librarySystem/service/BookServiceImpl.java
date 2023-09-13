package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.exception.GlobalException;
import com.samkingworld.librarySystem.model.Book;
import com.samkingworld.librarySystem.model.BorrowedBook;
import com.samkingworld.librarySystem.model.User;
import com.samkingworld.librarySystem.repository.BookRepository;
import com.samkingworld.librarySystem.repository.BorrowedBookRepository;
import com.samkingworld.librarySystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BorrowedBookRepository borrowedBookRepo;

    @Autowired
    UserRepository userRepo;


    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    @Transactional()
    @CacheEvict(value = {"allBooks", "getBook"}, allEntries = true)
    public Book addBook(Book book) {
        try {
            book.setCreatedDateTime(bookRepo.createTime());
            book.setBorrowed(false);
            return bookRepo.save(book);
        }catch (Exception e){
            Book s = new Book();
            s.setAuthor(e.getMessage().substring(e.getMessage().indexOf("["), e.getMessage().indexOf("[", e.getMessage().indexOf("[") +1)));
            s.setTitle(e.getMessage().substring(e.getMessage().indexOf("["), e.getMessage().indexOf("[", e.getMessage().indexOf("[") +1)));
            s.setPublicationYear(e.getMessage().substring(e.getMessage().indexOf("["), e.getMessage().indexOf("[", e.getMessage().indexOf("[") +1)));
            s.setIsbn(e.getMessage().substring(e.getMessage().indexOf("["), e.getMessage().indexOf("[", e.getMessage().indexOf("[") +1)));
            return s;
        }

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String borrowBook(BorrowedBook request) {
        Optional<User> user =  userRepo.findByUserId(request.getUserId());
        Book book = bookRepo.findByTitle(request.getBookName());
        if(user.isPresent() && book != null){
            book.setBorrowed(true);
            request.setBorrowedDateTime(borrowedBookRepo.borrowedTime());
            borrowedBookRepo.save(request);
            bookRepo.save(book);
            return "Successful";
        }
        else {
            return "user does not exist. Please register first";
        }

    }

    @Override
    @CacheEvict(value = "allBooks", allEntries = true)
    public String deleteBookByIsbn(String isbn) {
        bookRepo.deleteByIsbn(isbn);
        return "Book deleted successfully";
    }

    @Override
    @CacheEvict(value = {"allBooks", "getBook"}, allEntries = true)
    public String deleteBookById(Long bookId) {
        bookRepo.deleteById(bookId);
        return "Book deleted successfully";
    }

    @Override
    @Cacheable(value = "getBook", key = "#isbn")
    public Book getBookByIsbn(String isbn) {
        return bookRepo.findByIsbn(isbn);
    }

    @Override
    @Cacheable(value = "getBook", key = "#author")
    public List<Book> getBookByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    @Override
    @Cacheable(value = "getBook", key = "#title")
    public Book getBookByTitle(String title) {
        return bookRepo.findByTitle(title);
    }



}
