package com.realestate.web.example.domain;

import com.realestate.web.example.domain.enums.Status;
import com.realestate.web.example.domain.interfaces.IFacility;

import java.math.BigInteger;
import java.util.List;

public class FacilityObject {

    private Status status;
    private BigInteger monthRent;
    private BigInteger price;
    private BigInteger commissionAmount;
    private RealEstateAgent agent;
    private List<IFacility> facilities;

    public FacilityObject() {
    }

    public FacilityObject(Status status, BigInteger monthRent,
                          BigInteger price, BigInteger commissionAmount,
                          RealEstateAgent agent, List<IFacility> facilities) {
        this.status = status;
        this.monthRent = monthRent;
        this.price = price;
        this.commissionAmount = commissionAmount;
        this.agent = agent;
        this.facilities = facilities;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigInteger getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(BigInteger monthRent) {
        this.monthRent = monthRent;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigInteger commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public RealEstateAgent getAgent() {
        return agent;
    }

    public void setAgent(RealEstateAgent agent) {
        this.agent = agent;
    }

    public List<IFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<IFacility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "FacilityObject{" +
                "status=" + status +
                ", monthRent=" + monthRent +
                ", price=" + price +
                ", commissionAmount=" + commissionAmount +
                ", agent=" + agent +
                ", facilities=" + facilities +
                '}';
    }
}
