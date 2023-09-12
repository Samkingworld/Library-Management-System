package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.model.Book;
import com.samkingworld.librarySystem.model.BorrowedBook;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book addBook(Book book);
    public String borrowBook(BorrowedBook request);
    public String deleteBookByIsbn(String isbn);
    String deleteBookById(Long bookId);
    public Book getBookByIsbn(String isbn);
    public List<Book> getBookByAuthor(String author);
    public Book getBookByTitle(String title);
//    public Book updateBookByISBN(String isbn_no);





}
