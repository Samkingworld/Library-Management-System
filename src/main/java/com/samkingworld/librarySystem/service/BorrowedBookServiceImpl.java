package com.samkingworld.librarySystem.service;

import com.samkingworld.librarySystem.model.Book;
import com.samkingworld.librarySystem.model.BorrowedBook;
import com.samkingworld.librarySystem.repository.BookRepository;
import com.samkingworld.librarySystem.repository.BorrowedBookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBookServiceImpl implements BorrowedBookService{

    @Autowired
    private BorrowedBookRepository bbRepo;
    @Autowired
    private BookRepository bookRepo;

    @Override
    public List<BorrowedBook> getBorrowedBookByUserId(String userId) {
        return bbRepo.findBorrowedBookByUserId(userId);
    }

    @Override
    public String returnBook(String user_id) {
        List<BorrowedBook> book = bbRepo.findBorrowedBookByUserId(user_id);
        book.stream()
                .forEach(borrowedBook -> {
                    Book book1 = bookRepo.findByTitle(borrowedBook.getBookName());
                    book1.setBorrowed(false);
                    bookRepo.save(book1);
                    bbRepo.delete(borrowedBook);

                });

        return "Book successfully returned";
    }

    @Override
    public List<BorrowedBook> getAllBorrowedBooks() {
        return bbRepo.findAll();
    }


}
