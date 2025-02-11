package com.blopping.AppBlopping.blogPost;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostRepository blogPostRepository;

    public List<BlogPost> findAll() { return blogPostRepository.findAll(); }
    public BlogPost modify(Long id, BlogPostRequest blogPostRequest) {
        BlogPost blogPost = findById(id);
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPostRepository.save(blogPost);
        return blogPost;


    }
    public BlogPost save(BlogPostRequest blogPostRequest) {
        BlogPost blogPost = new BlogPost();
        BeanUtils.copyProperties(blogPostRequest, blogPost);
        blogPostRepository.save(blogPost);
        return blogPost;
    }
    public BlogPost findById(Long id) {
        if(!blogPostRepository.existsById(id))
            throw new EntityNotFoundException("BlogPost not found");
            return blogPostRepository.findBy(id).get();
        }
        public void delete(Long id) {
            if(!blogPostRepository.existsById(id))
                throw new EntityNotFoundException("BlogPost not found");
            blogPostRepository.deleteById(id);
        }

}


