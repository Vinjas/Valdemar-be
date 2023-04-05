package com.apirest.valdemarbe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.valdemarbe.model.entitybean.Author;
import com.apirest.valdemarbe.model.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public List<Author> findByCollection(String id) {
        return authorRepo.findByCollection(id);
    }

    @Override
    public Author findOne(String id) {
        return authorRepo.findOne(id);
    }

    @Override
    public int saveAuthor(Author author) {
        try {
            authorRepo.save(author);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteAuthor(String id) {
        try {
            authorRepo.deleteById(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
