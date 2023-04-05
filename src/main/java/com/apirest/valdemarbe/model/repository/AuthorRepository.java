package com.apirest.valdemarbe.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apirest.valdemarbe.model.entitybean.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {

    @Query("SELECT a FROM Author a JOIN a.collections c WHERE c.id = ?1")
    List<Author> findByCollection(String id);

    @Query("select a from Author a where a.id = ?1")
    public Author findOne(String id);

}
