package telran.java51.book.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java51.book.dto.AuthorDto;
import telran.java51.book.dto.BookDto;
import telran.java51.book.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public boolean addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn (@PathVariable String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping("/book/{isbn}")
    public BookDto deleteBook(@PathVariable String isbn) {
        return bookService.remove(isbn);
    }

    @PutMapping("/book/{isbn}/title/{newTitle}")
    public BookDto updateBookTitle(@PathVariable String isbn, @PathVariable String newTitle) {
        return bookService.updateBook(isbn, newTitle);
    }

    @GetMapping("/books/author/{authorName}")
    public Iterable<BookDto> findBooksByAuthor(@PathVariable String authorName) {
        return bookService.findBooksByAuthor(authorName);
    }

    @GetMapping("/books/publisher/{publisherName}")
    public Iterable<BookDto> findBooksByPublisher(@PathVariable String publisherName) {
        return bookService.findBooksByPublisher(publisherName);
    }

    @GetMapping("/authors/book/{isbn}")
    public Iterable<AuthorDto> findAuthorsByBook(@PathVariable String isbn) {
        return bookService.findBookAuthors(isbn);
    }

    @GetMapping("/publishers/author/{authorName}")
    public Iterable<String> findPublishersByAuthor(@PathVariable String authorName) {
        return bookService.findPublishersByAuthor(authorName);
    }
    @DeleteMapping("/author/{authorName}")
    public AuthorDto deleteAuthor(@PathVariable String authorName) {
        return bookService.removeAuthor(authorName);
    }
}
