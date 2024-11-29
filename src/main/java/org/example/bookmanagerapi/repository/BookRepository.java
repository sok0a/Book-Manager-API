package org.example.bookmanagerapi.repository;

import org.example.bookmanagerapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}