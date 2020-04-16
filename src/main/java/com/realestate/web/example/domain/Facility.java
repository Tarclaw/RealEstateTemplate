package com.realestate.web.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "facilities")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Facility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;
    private Integer numberOfRooms;
    private Integer totalArea;
    private String description;

    @ManyToOne
    private FacilityObject facilityObject;

    @Lob
    private List<Byte[]> photos;

    @Lob
    private List<Byte[]> videos;

    @Embedded
    private Address address;

    public Facility() {
    }

    public Facility(Integer numberOfRooms, Integer totalArea, String description,
                               List<Byte[]> photos, List<Byte[]> videos, Address address) {
        this.numberOfRooms = numberOfRooms;
        this.totalArea = totalArea;
        this.description = description;
        this.photos = photos;
        this.videos = videos;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Integer totalArea) {
        this.totalArea = totalArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Byte[]> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Byte[]> photos) {
        this.photos = photos;
    }

    public List<Byte[]> getVideos() {
        return videos;
    }

    public void setVideos(List<Byte[]> videos) {
        this.videos = videos;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public FacilityObject getFacilityObject() {
        return facilityObject;
    }

    public void setFacilityObject(FacilityObject facilityObject) {
        this.facilityObject = facilityObject;
    }

    @Override
    public String toString() {
        return "FacilityCredentials{" +
                "numberOfRooms=" + numberOfRooms +
                ", totalArea=" + totalArea +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(id, facility.id) &&
                Objects.equals(numberOfRooms, facility.numberOfRooms) &&
                Objects.equals(totalArea, facility.totalArea) &&
                Objects.equals(description, facility.description) &&
                Objects.equals(photos, facility.photos) &&
                Objects.equals(videos, facility.videos) &&
                Objects.equals(address, facility.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfRooms, totalArea, description, photos, videos, address);
    }
}
