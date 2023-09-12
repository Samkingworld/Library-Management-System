package com.samkingworld.librarySystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private String userId;

    @NotNull(message = "book name cannot be null")
    @NotEmpty(message = "book name cannot be empty")
    @Column(name = "book_name")
    private String bookName;

    @NotNull(message = "book author cannot be null")
    @NotEmpty(message = "book author cannot be empty")
    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "last_modified_date_time")
    private String borrowedDateTime;




}
