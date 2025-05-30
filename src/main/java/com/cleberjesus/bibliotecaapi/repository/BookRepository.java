package com.cleberjesus.bibliotecaapi.repository;

import com.cleberjesus.bibliotecaapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    boolean findByTitle(String Title);

    List<Book> findByAuthor(String author);

    boolean existsByTitle(String title);

}
