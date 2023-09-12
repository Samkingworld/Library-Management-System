package com.samkingworld.librarySystem.repository;

import com.samkingworld.librarySystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long>{

    @Query(value = "SELECT current_timestamp()", nativeQuery = true)
    String createTime();
    Book findByTitle(String title);
    Book findByIsbn(String isbn_number);

    List<Book> findByAuthor(String author);
    Optional<List<Book>> findBookByPublicationYear(String pub_year);

    void deleteByIsbn(String isbn);
}
