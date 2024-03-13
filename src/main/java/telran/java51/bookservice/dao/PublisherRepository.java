package telran.java51.bookservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import telran.java51.bookservice.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, String> {

    @Query("select b.publisher from Book b join b.authors ba where ba.name = :authorName")
//    @Query("select distinct b.publisher.publisherName from Book b join b.authors ba where ba.name = :authorName")
    List<String> findPublishersByAuthor(String authorName);
}
