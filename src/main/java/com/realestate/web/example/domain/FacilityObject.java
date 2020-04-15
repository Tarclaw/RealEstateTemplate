package com.realestate.web.example.domain;

import com.realestate.web.example.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "facility_objects")
public class FacilityObject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;
    private BigInteger monthRent;
    private BigInteger price;
    private BigInteger commissionAmount;

    @ManyToOne
    @JoinColumn(name="fk_agent")
    private RealEstateAgent agent;

    @OneToMany(mappedBy = "facility_objects")
    private List<Facility> facilities;

    public FacilityObject() {
    }

    public FacilityObject(Status status, BigInteger monthRent,
                          BigInteger price, BigInteger commissionAmount,
                          RealEstateAgent agent, List<Facility> facilities) {
        this.status = status;
        this.monthRent = monthRent;
        this.price = price;
        this.commissionAmount = commissionAmount;
        this.agent = agent;
        this.facilities = facilities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacilityObject that = (FacilityObject) o;
        return Objects.equals(id, that.id) &&
                status == that.status &&
                Objects.equals(monthRent, that.monthRent) &&
                Objects.equals(price, that.price) &&
                Objects.equals(commissionAmount, that.commissionAmount) &&
                Objects.equals(agent, that.agent) &&
                Objects.equals(facilities, that.facilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, monthRent, price, commissionAmount, agent, facilities);
    }
}
