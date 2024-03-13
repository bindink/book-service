package telran.java51.bookservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;

    @Id
    String isbn;
    @Column(name = "TITLE")
    String title;
    @ManyToMany
    @JoinTable(name = "BOOK_AUTHORS",
            joinColumns = @JoinColumn(name = "BOOKS_ISBN"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORS_NAME"))
    Set<Author> authors;
    @ManyToOne
    Publisher publisher;
}
