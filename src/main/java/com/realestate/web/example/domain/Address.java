package com.realestate.web.example.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private Integer postcode;
    private Integer facilityNumber;
    private String city;
    private String district;
    private String street;

    public Address() {
    }

    public Address(Integer postcode, Integer facilityNumber,
                   String city, String district, String street) {
        this.postcode = postcode;
        this.facilityNumber = facilityNumber;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public Integer getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(Integer facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postcode=" + postcode +
                ", facilityNumber=" + facilityNumber +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
