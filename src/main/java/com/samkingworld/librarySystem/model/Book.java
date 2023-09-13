package com.samkingworld.librarySystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = {"id", "isbn"}))
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Book Title cannot be empty")
    @NotNull(message = "Book Title cannot be null")
    @Column(nullable = false)
    private String title;

    @NotEmpty(message = "Book Author cannot be empty")
    @NotNull(message = "Book Author cannot be null")
    @Column(nullable = false)
    private String author;

    @NotEmpty(message = "Book ISBN  cannot be empty")
    @NotNull(message = "Book ISBN cannot be null")
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotEmpty(message = "Book publication year cannot be empty")
    @NotNull(message = "Book publication year cannot be null")
    @Column(name = "pub_year", nullable = false)
    private String publicationYear;

    @Column(name = "created_date_time")
    private String createdDateTime;

    @Column(name = "is_borrowed")
    private boolean isBorrowed;

}
