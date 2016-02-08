package com.milanvasic.sample.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.joda.time.LocalDate;

@Entity
@Table(name = "company_owners")
public class CompanyOwners {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "company_id")

    private Integer company_id;

    @Column(name = "owner_name")


    private String owner_name;


    public long getId() {
        return id;
    }


    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyOwners)) return false;
        CompanyOwners that = (CompanyOwners) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
