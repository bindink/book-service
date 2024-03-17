package telran.java51.book.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import telran.java51.book.model.Publisher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

    @PersistenceContext
    EntityManager em;

    //not used. the same as findDistinctByBooksAuthorsName()
    @Override
    public List<String> findByPublishersAuthor(String authorName) {
        return (List<String>) em.createQuery("select distinct b.publisher.publisherName from Book b join b.authors ba where ba.name = ?1")
                .setParameter(1, authorName)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
        return em.createQuery("select distinct b.publisher from Book b join b.authors ba where ba.name = ?1")
                .setParameter(1, authorName)
                .getResultStream();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class, publisher));
    }

    @Override
//	@Transactional
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
//		em.merge(publisher);
        return publisher;
    }

}