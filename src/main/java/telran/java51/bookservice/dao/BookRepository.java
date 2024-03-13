package telran.java51.bookservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import telran.java51.bookservice.model.Book;

import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, String> {
//    @Query("select b from Book b join b.authors a where lower(a.name) = lower(?1)")
    Stream<Book> findByAuthorsName(String author);

//    @Query("select b from Book b join b.publisher p where lower(p.publisherName) = lower(?1)")
    Stream<Book> findByPublisherPublisherName(String publisher);
}
