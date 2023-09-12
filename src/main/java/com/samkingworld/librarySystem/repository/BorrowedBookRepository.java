package com.samkingworld.librarySystem.repository;

import com.samkingworld.librarySystem.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    @Query(value = "SELECT current_timestamp()", nativeQuery = true)
    String borrowedTime();

    @Query(value = "SELECT * FROM borrowed_books where user_id = :userId", nativeQuery = true)
    List<BorrowedBook> findBorrowedBookByUserId(@Param("userId") String userId);


}
