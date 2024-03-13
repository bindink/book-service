package telran.java51.bookservice.service;

import telran.java51.bookservice.dto.AuthorDto;
import telran.java51.bookservice.dto.BookDto;

public interface BookService {
    boolean addBook(BookDto bookDto);
    BookDto findBookByIsbn(String isbn);
    BookDto deleteBook(String isbn);
    BookDto updateBookTitle(String isbn, String title);
    Iterable<BookDto> findBooksByAuthor(String author);

    Iterable<BookDto> findBooksByPublisher(String publisher);

    Iterable<AuthorDto> findAuthorsByBook(String isbn);

    Iterable<String> findPublishersByAuthor(String author);

    AuthorDto deleteAuthor(String authorName);
}
