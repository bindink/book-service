package telran.java51.book.model;

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
            joinColumns = @JoinColumn(name = "BOOK_ISBN"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORS_NAME"))
    Set<Author> authors;
    @ManyToOne
    @JoinColumn(name="PUBLISHER_PUBLISHER_NAME", nullable=false)
    Publisher publisher;
}
