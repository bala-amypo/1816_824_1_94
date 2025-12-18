package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Bin
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
public void setId(Long id)
{
  this.id=id;
}
public String getIdentifier()
{
    return identifier;
}
public void setIdentifier(String identifier)
{
  this.identifier=identifier;
}
public String getLocationDescription()
{
    return locationDescription;
}
public void setLocationDescription(String locationDescription)
{
  this.locationDescription=locationDescription;
}
public Double getLatitude()
{
    return latitude;
}
public void setLatitude(Double latitude)
{
  this.latitude=latitude;
}
public Double getLongitude()
{
    return longitude;
}
public void setLongitude(Double longitude)
{
  this.longitude=longitude;
}
public Double getcapacityLiters()
{
    return capacityLiters;
}
public void setcapacityLiters(Double capacityLiters)
{
  this.capacityLiters=capacityLiters;
}
public Boolean getactive()
{
    return active;
}
public void setactive(Boolean active)
{
  this.active=active;
}
public Bin(Long id,String identifier,String locationDescription,Double latitude,Double longitude,Double capacityLiters,Boolean active)
{
  this.id=id;
  this.identifier=identifier;
  this.locationDescription=locationDescription;
  this.latitude=latitude;
  this.longitude=longitude;
  this.capacityLiters=capacityLiters;
  this.active=active;
}
public Bin(){}
}