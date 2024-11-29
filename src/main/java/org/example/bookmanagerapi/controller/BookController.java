package org.example.bookmanagerapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.bookmanagerapi.dto.BookRequestDto;
import org.example.bookmanagerapi.entity.Book;
import org.example.bookmanagerapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @ResponseBody
    @PostMapping("/api/books")
    public ResponseEntity<?> save(@RequestBody BookRequestDto requestDto) {
        bookService.save(requestDto);
        return ResponseEntity.ok().build();
    }
    @ResponseBody
    @GetMapping("/api/books/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findById(id));
    }
    @ResponseBody
    @GetMapping("/api/books")
    public ResponseEntity<?> getAll() {
        List<Book> result = bookService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/api/books/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        bookService.update(id, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }


}
