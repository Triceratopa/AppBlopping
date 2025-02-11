package com.blopping.AppBlopping.blogPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPostRequest {

    private String category;
    private String title;
    private String coverimage;
    private String content;
    private int timeread;
}
