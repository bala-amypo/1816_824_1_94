
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class bin
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String identifier;
    private String locationDescription;
    private Double latitude;
    private Double longitude;
    private Double capacityLiters;
    private Boolean active;

public Long getId()
{
    return id;
}
public Long setId(Long id)
{
  this.id=id;
}
public String getIdentifier()
{
    return identifier;
}
public String setIdentifier(String identifier)
{
  this.identifier=identifier;
}
public String getLocationDescription()
{
    return LocationDescription;
}
public String setLocationDescription(String LocationDescription)
{
  this.LocationDescription=LocationDescription;
}
public Double getLatitute()
{
    return latitude;
}
public Double setLatitude(Double latitude)
{
  this.latitude=latitude;
}
public Double getLongitude()
{
    return longitude;
}
public Double setLongitude(Double longitude)
{
  this.longitude=longitude;
}
public Double getcapacityLiters()
{
    return capacityLiters;
}
public Double setcapacityliters(Double capacityLiters)
{
  this.capacityLiters=capacityLiters;
}
public Boolean getactive()
{
    return active;
}
public Boolean setactive(Boolean active)
{
  this.active=active;
}
public bin(Long id,)
}