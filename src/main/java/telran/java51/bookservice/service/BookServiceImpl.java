package telran.java51.bookservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import telran.java51.bookservice.dao.AuthorRepository;
import telran.java51.bookservice.dao.BookRepository;
import telran.java51.bookservice.dao.PublisherRepository;
import telran.java51.bookservice.dto.AuthorDto;
import telran.java51.bookservice.dto.BookDto;
import telran.java51.bookservice.exception.EntityNotFoundExсeption;
import telran.java51.bookservice.model.Author;
import telran.java51.bookservice.model.Book;
import telran.java51.bookservice.model.Publisher;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    final BookRepository bookRepository;
    final ModelMapper modelMapper;
    final PublisherRepository publisherRepository;
    final AuthorRepository authorRepository;

    @Override
    @Transactional
    public boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())) {
            return false;
        }
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher()).orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));
        Set<Author> authors = bookDto.getAuthors().stream().map(a -> authorRepository.findById(a.getName()).orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate())))).collect(Collectors.toSet());
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundExсeption::new);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    @Transactional
    public BookDto deleteBook(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundExсeption::new);
        bookRepository.deleteById(isbn);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    @Transactional
    public BookDto updateBookTitle(String isbn, String newTitle) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundExсeption::new);
        book.setTitle(newTitle);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<BookDto> findBooksByAuthor(String author) {
        return bookRepository.findByAuthorsName(author)
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<BookDto> findBooksByPublisher(String publisher) {
        return bookRepository.findByPublisherPublisherName(publisher)
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<AuthorDto> findAuthorsByBook(String isbn) {
        return authorRepository.findById(isbn)
                .stream()
                .map(a -> modelMapper.map(a, AuthorDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Iterable<String> findPublishersByAuthor(String author) {
        return publisherRepository.findPublishersByAuthor(author);
    }
}
