
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class bin
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
}