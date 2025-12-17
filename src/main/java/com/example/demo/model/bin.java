
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.column;
@Entity
public class bin
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @column(unique=true)
    private String identifier;
    private String locationDescription;
    private Double latitude;
    private Double longitude;
    private Double capacityLiters;
    private Boolean active;


}

