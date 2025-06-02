package com.cleberjesus.bibliotecaapi.controller;


import com.cleberjesus.bibliotecaapi.model.Book;
import com.cleberjesus.bibliotecaapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<Book> register(@RequestBody Book book){
        bookService.registerBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
   }

   @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Integer id){
        Book book = bookService.get(id);
        return ResponseEntity.ok(book);
   }

   @PutMapping("{id}")
   public ResponseEntity<Book> edit(@PathVariable("id") Integer id, @RequestBody Book book){
        book.setId(id);
        bookService.putBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
   }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
            String result = bookService.delete(id);
            return ResponseEntity.ok(result);
    }

    @GetMapping("/by-author")
    public List<Book> getByAuthor(@RequestParam("author") String author) {
        return bookService.getByAuthor(author);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }


}
