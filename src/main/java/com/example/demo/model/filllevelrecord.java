import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class filllevelrecord
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double fillPercentage;
    private Boolean isWeekend;
    public Long getid()
    {
        return id;
    }
    public void setid(Long id)
    {
        this.id=id;
    }
    public Double getfillPercentage()
    {
        return id;
    }
    public void setfillPercentage()
    {
        this.id=id;
    }
    public Long getid()
    {
        return id;
    }
    public void setid(LOng id)
    {
        this.id=id;
    }
}
