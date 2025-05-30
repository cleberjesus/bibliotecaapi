package com.cleberjesus.bibliotecaapi.service;

import com.cleberjesus.bibliotecaapi.model.Book;
import com.cleberjesus.bibliotecaapi.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book registerBook(Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo não pode estar vazia");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Autor não pode estar vazio");
        }
        if (book.getYearPublication() > Year.now().getValue()) {
            throw new IllegalArgumentException("Não é possível armazenar um livro com o ano maior que " + Year.now());
        }
        if (bookRepository.existsByTitle(book.getTitle())) {
            throw new IllegalArgumentException("Já existe um livro com este nome");
        }

        return bookRepository.save(book);
    }

    public Book get(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro com id " + id + " não encontrado"));
    }


    public String delete(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Não é possível deletar esse livro, pois não foi encontrado");
        }
        bookRepository.deleteById(id);
        return "O livro foi deletado com sucesso";
    }

    public Book putBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            throw new IllegalArgumentException("Não é possível editar pois não existe este Livro");
        }
        registerBook(book);
        return bookRepository.save(book);
    }

    public List<Book> getByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if (!books.isEmpty()) {
            throw new IllegalArgumentException("Nenhum livro encontrado para o autor: " + author);
        }
        return books;
    }
}
