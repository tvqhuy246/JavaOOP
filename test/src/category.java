import jakarta.persistence.*;
import java.util.List;
import java.lang.String;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Book> books;

}
