package telran.java51.book.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class BookDto {
     String isbn;
     String title;
     Set<AuthorDto> authors;
    String publisher;
}
