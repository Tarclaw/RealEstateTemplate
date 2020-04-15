package com.realestate.web.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "garages")
public class Garage extends Facility {

    private boolean hasPit;
    private boolean hasEquipment;

    public Garage() {
    }

    public Garage(boolean hasPit, boolean hasEquipment) {
        this.hasPit = hasPit;
        this.hasEquipment = hasEquipment;
    }

    public Garage(Integer numberOfRooms, Integer totalArea, String description,
                  List<Byte[]> photos, List<Byte[]> videos,
                  Address address, boolean hasPit, boolean hasEquipment) {
        super(numberOfRooms, totalArea, description, photos, videos, address);
        this.hasPit = hasPit;
        this.hasEquipment = hasEquipment;
    }

    public boolean isHasPit() {
        return hasPit;
    }

    public void setHasPit(boolean hasPit) {
        this.hasPit = hasPit;
    }

    public boolean isHasEquipment() {
        return hasEquipment;
    }

    public void setHasEquipment(boolean hasEquipment) {
        this.hasEquipment = hasEquipment;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "hasPit=" + hasPit +
                ", hasEquipment=" + hasEquipment +
                '}';
    }
}
