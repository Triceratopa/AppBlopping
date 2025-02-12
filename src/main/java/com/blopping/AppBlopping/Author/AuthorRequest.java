package com.blopping.AppBlopping.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {

    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
}
