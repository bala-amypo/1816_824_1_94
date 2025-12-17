
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
im
@Entity
public class bin
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @column(unique=true)
    private String identifier;
    private String 
}