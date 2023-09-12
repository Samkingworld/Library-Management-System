package com.samkingworld.librarySystem.utils;

import com.samkingworld.librarySystem.model.BorrowedBook;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReqest {

    private String full_name;
    private String email;
    private int age;
    private String address;
    private String phone_no;

}
