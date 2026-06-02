import jakarta.persistence.*;
import java.util.List;
import java.lang.String;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public void setCat(Category category){
        this.category = category;
    }
    public Category getCat(){
        return category;
    }
    private List<Arthur> arthur;
}
