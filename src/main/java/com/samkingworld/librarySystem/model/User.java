package com.samkingworld.librarySystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "email", "id"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private String userId;

    @NotNull(message = "Please enter your full name")
    @NotEmpty(message = "This field cannot be empty")
    @Length(min = 5, max = 50, message = "Your name cannot be less that 5 or greater than 15 characters")
    private String full_name;

    @NotNull
    @Email(message = "Please type in your correct email.")
    @NotEmpty
    @Column(unique = true)
    private String email;

    @Digits(message = "Age must be a number", integer = 2, fraction = 0)
    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 70, message = "Age cannot be greater than 70")
    private int age;

    @NotEmpty(message = "Address field cannot be empty")
    @NotNull(message = "This field cannot be null")
    private String address;

    @Digits(integer = 11, fraction = 0, message = "This can only be a number")
    private String phone_no;

    @Column(name = "created_date_time", nullable = false)
    private String createdDateTime;

    @Column(name = "last_modified_date_time")
    private String lastModifiedDateTime;

//    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<BorrowedBook> borrowedBooks;

}


