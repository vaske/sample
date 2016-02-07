package com.milanvasic.sample.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.joda.time.LocalDate;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    private long id;


    @Column(name = "company_id")


    private Integer company_id;

    @Column(name = "name", length = 155)
    @Size(max = 155)


    private String name;

    @Column(name = "address", length = 255)
    @Size(max = 255)


    private String address;

    @Column(name = "city", length = 155)
    @Size(max = 155)


    private String city;

    @Column(name = "country", length = 115)
    @Size(max = 115)


    private String country;

    @Column(name = "email", length = 255)
    @Size(max = 255)




    private String email;

    @Column(name = "phone_number", length = 200)
    @Size(max = 200)




    private String phone_number;

    @Column(name = "no_employees")

    @Min(value = 1)



    private Integer no_employees;


    public long getId() {
        return id;
    }


    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getNo_employees() {
        return no_employees;
    }

    public void setNo_employees(Integer no_employees) {
        this.no_employees = no_employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company that = (Company) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
