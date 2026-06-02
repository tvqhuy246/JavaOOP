import jakarta.persistence.*;
import java.util.List;
import java.lang.String;
@Entity
public class Arthur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @ManyToMany
    @JoinTable(
            name = "Huy",
            joinColumns = @JoinColumn(name = "book_id")
    )
    
    private List<Book> books;
}
