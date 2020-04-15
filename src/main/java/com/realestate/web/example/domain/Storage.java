package com.realestate.web.example.domain;

import java.util.List;

public class Storage extends Facility {

    private Integer commercialCapacity;
    private boolean hasCargoEquipment;

    public Storage() {
    }

    public Storage(Integer commercialCapacity, boolean hasCargoEquipment) {
        this.commercialCapacity = commercialCapacity;
        this.hasCargoEquipment = hasCargoEquipment;
    }

    public Storage(Integer numberOfRooms, Integer totalArea, String description,
                   List<Byte[]> photos, List<Byte[]> videos, Address address,
                   Integer commercialCapacity, boolean hasCargoEquipment) {
        super(numberOfRooms, totalArea, description, photos, videos, address);
        this.commercialCapacity = commercialCapacity;
        this.hasCargoEquipment = hasCargoEquipment;
    }

    public Integer getCommercialCapacity() {
        return commercialCapacity;
    }

    public void setCommercialCapacity(Integer commercialCapacity) {
        this.commercialCapacity = commercialCapacity;
    }

    public boolean isHasCargoEquipment() {
        return hasCargoEquipment;
    }

    public void setHasCargoEquipment(boolean hasCargoEquipment) {
        this.hasCargoEquipment = hasCargoEquipment;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "commercialCapacity=" + commercialCapacity +
                ", hasCargoEquipment=" + hasCargoEquipment +
                '}';
    }
}
