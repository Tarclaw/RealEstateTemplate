package com.realestate.web.example.domain;

import com.realestate.web.example.domain.interfaces.IFacility;

import java.util.List;

public class Facility implements IFacility {

    private Integer numberOfRooms;
    private Integer totalArea;
    private String description;
    private List<Byte[]> photos;
    private List<Byte[]> videos;
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

    @Override
    public String toString() {
        return "FacilityCredentials{" +
                "numberOfRooms=" + numberOfRooms +
                ", totalArea=" + totalArea +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }
}
