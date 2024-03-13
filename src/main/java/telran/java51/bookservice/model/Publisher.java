package telran.java51.bookservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

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

//    @Override
//    public String toString() {
//        return publisherName;
//    }
}
