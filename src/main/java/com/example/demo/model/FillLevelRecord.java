import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class FillLevelRecord
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
    public void setfillPercentage(Double fillPercentage)
    {
        this.fillPercentage=fillPercentage;
    }
    public Boolean getisWeekend()
    {
        return isWeekend;
    }
    public void setisWeekend(Boolean isWeekend)
    {
        this.isWeekend=isWeekend;
    }
    public FillLevelRecord(Long id,Double fillPercentage,Boolean isWeekend)
    {
        this.id=id;
        this.fillPercentage=fillPercentage;
        this.isWeekend=isWeekend;
    }
    public FillLevelRecord(){}
}
