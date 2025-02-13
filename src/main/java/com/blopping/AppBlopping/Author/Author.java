package com.blopping.AppBlopping.Author;

import com.blopping.AppBlopping.blogPost.BlogPost;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;

    @OneToMany
    @ToString.Exclude
    @JsonIgnoreProperties("author")

    private List<BlogPost> blogList = new ArrayList<>();

}
