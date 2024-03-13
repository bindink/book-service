package telran.java51.bookservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import telran.java51.bookservice.model.Author;

import java.util.stream.Stream;

public interface AuthorRepository extends JpaRepository<Author, String> {
    @Query("select b.authors from Book b where b.isbn = ?1")
    Stream<Author> findAuthorsByBook(String isbn);
}
