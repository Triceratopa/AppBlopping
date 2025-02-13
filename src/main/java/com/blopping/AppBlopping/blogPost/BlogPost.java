package com.blopping.AppBlopping.blogPost;

import com.blopping.AppBlopping.Author.Author;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor

public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String title;
    private String coverimage;
    private String content;
    private int timeread;

    @OneToMany
    @ToString.Exclude
    @JsonIgnoreProperties("blogList")

    private Author author;



}
