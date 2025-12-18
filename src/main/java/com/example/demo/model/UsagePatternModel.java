import com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class UsagePatternModel
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double avgDailyIncreaseWeekday;
    private Double avgDailyIncreaseWeekend;
    public Long getid()
    {
        return id;
    } 
    public void setid(Long id)
    {
         this.id=id;
    }
    public Double getavgDailyIncreaseWeekday()
    {
        return avgDailyIncreaseWeekday;
    }
    public void setavgDailyIncreaseWeekday(Double avgDailyIncreaseWeekday)
    {
        this.avgDailyIncreaseWeekday=avgDailyIncreaseWeekday;
    }
     public Double getavgDailyIncreaseWeekend()
    {
        return avgDailyIncreaseWeekend;
    }
    public void setavgDailyIncreaseWeekend(Double avgDailyIncreaseWeekend)
    {
        this.avgDailyIncreaseWeekend=avgDailyIncreaseWeekend;
    }
    public UsagePatternModel(Long id,Double avgDailyIncreaseWeekday,Double avgDailyIncreaseWeekend)
    {
        
    }
}