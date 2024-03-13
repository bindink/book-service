package telran.java51.bookservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Publisher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    @Id
    String publisherName;
    @OneToMany(mappedBy="publisher")
    Set<Book>books;
    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return publisherName;
    }
}
