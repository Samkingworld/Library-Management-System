package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.model.BorrowedBook;

import java.util.List;

public interface BorrowedBookService {
    public List<BorrowedBook> getBorrowedBookByUserId(String userId);
    public String returnBook(String isbn);

    List<BorrowedBook> getAllBorrowedBooks();
}
