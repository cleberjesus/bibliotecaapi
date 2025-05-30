package com.cleberjesus.bibliotecaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Year;

@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "yearPublication")
    private Integer yearPublication;
    @Column(name = "available")
    private boolean available;
}
