package org.example.bookmanagerapi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}