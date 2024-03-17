package telran.java51.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import telran.java51.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    EntityManager em;

    //not used. instead use findById in authorRepository --> author.getBooks
    @Override
    public Stream<Book> findByAuthorsName(String name) {
        //Uni-directional
        return em.createQuery("select b from Book b join b.authors a where lower(a.name) = lower(?1)")
                .setParameter(1, name)
                .getResultStream();
//      Bi-directional
//        return em.createQuery("select a.books from Author a where lower(a.name) = lower(?1)")
//                .setParameter(1, name)
//                .getResultStream();
    }

    @Override
    public Stream<Book> findByPublisherPublisherName(String name) {
        //Uni-directional
        return em.createQuery("select b from Book b join b.publisher p where lower(p.publisherName) = lower(?1)")
                .setParameter(1, name)
                .getResultStream();
//       todo how to make Bi-directional
//        return em.createQuery("select p.books from Publisher p where lower(p.publisherName) = lower(?1)")
//                .setParameter(1, name)
//                .getResultStream();
    }

    //not used. instead use findById and delete in authorRepository
    @Override
    public void deleteByAuthorsName(String name) {
        findByAuthorsName(name)
                .forEach(book -> em.remove(book));
    }

    @Override
    public boolean existsById(String isbn) {
        return em.find(Book.class, isbn) != null;
    }

    @Override
    public Book save(Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(em.find(Book.class, isbn));
    }

//    @Override
//    public void deleteById(String isbn) {
//        Book book = em.find(Book.class, isbn);
//        em.remove(book);
//    }

    @Override
    public void delete(Book book) {
        em.remove(book);
    }

}
