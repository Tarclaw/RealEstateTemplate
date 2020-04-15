package com.realestate.web.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "basements")
public class Basement extends Facility {

    private boolean itCommercial;

    public Basement() {
    }

    public Basement(boolean itCommercial) {
        this.itCommercial = itCommercial;
    }

    public Basement(Integer numberOfRooms, Integer totalArea, String description,
                    List<Byte[]> photos, List<Byte[]> videos,
                    Address address, boolean itCommercial) {
        super(numberOfRooms, totalArea, description, photos, videos, address);
        this.itCommercial = itCommercial;
    }

    public boolean isItCommercial() {
        return itCommercial;
    }

    public void setItCommercial(boolean itCommercial) {
        this.itCommercial = itCommercial;
    }

    @Override
    public String toString() {
        return "Basement{" +
                "itCommercial=" + itCommercial +
                '}';
    }
}
