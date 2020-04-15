package com.realestate.web.example.domain;

import java.util.List;

public class Apartment extends Facility {

    private Integer apartmentNumber;
    private Integer floor;

    public Apartment() {
    }

    public Apartment(Integer apartmentNumber, Integer floor) {
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
    }

    public Apartment(Integer numberOfRooms, Integer totalArea, String description,
                     List<Byte[]> photos, List<Byte[]> videos,
                     Address address, Integer apartmentNumber, Integer floor) {
        super(numberOfRooms, totalArea, description, photos, videos, address);
        this.apartmentNumber = apartmentNumber;
        this.floor = floor;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentNumber=" + apartmentNumber +
                ", floor=" + floor +
                '}';
    }
}
