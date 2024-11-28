package org.example.bookmanagerapi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookRequestDto {
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}
