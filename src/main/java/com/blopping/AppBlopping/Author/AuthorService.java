package com.blopping.AppBlopping.Author;

import com.blopping.AppBlopping.Response.Response;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> findAll() { return authorRepository.findAll(); }

public Author modify(Long id, AuthorRequest authorRequest) {
    Author author = findById(id);
    BeanUtils.copyProperties(authorRequest, author);
    authorRepository.save(author);
    return author;
}
public Response save(AuthorRequest authorRequest) {
    Author author = new Author();
    BeanUtils.copyProperties(authorRequest, author);
    authorRepository.save(author);
   Response response = new Response();
   BeanUtils.copyProperties(author, response);
   return response;

}
public Author findById(Long id) {
    if(!authorRepository.existsById(id))
        throw new EntityNotFoundException("Author nope");
    return authorRepository.findById(id).get();
}
public void delete(Long id) {
    if(!authorRepository.existsById(id))
        throw new EntityNotFoundException("Author nope");
    authorRepository.deleteById(id);
}}

