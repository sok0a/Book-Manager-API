package org.example.bookmanagerapi.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmanagerapi.dto.BookRequestDto;
import org.example.bookmanagerapi.entity.Book;

import org.example.bookmanagerapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void save(BookRequestDto bookRequestDto) {

        Book book = Book.builder()
                .title(bookRequestDto.getTitle())
                .author(bookRequestDto.getAuthor())
                .isbn(bookRequestDto.getIsbn())
                .publishedDate(bookRequestDto.getPublishedDate())
                .build();
        bookRepository.save(book);
    }
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void update(Long id, BookRequestDto bookRequestDto) {

        Book book = bookRepository.findById(id).get();
        book.setTitle(bookRequestDto.getTitle());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setIsbn(bookRequestDto.getIsbn());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        bookRepository.save(book);
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


}