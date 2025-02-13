package com.blopping.AppBlopping.blogPost;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class BlogPostController {
    private final BlogPostService blogPostService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<BlogPostResponse> findAll(@RequestParam int page, @RequestParam int recordPerPagina, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(page, recordPerPagina, Sort.by(sortBy));
        return blogService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogDetailResponse findById(@PathVariable Long id) {
        return blogService.findBlogResponseFromId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody BlogRequest blogRequest) {
        return blogService.save(blogRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog modify(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        return blogService.modify(id, blogRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blogService.delete(id);
    }
}
