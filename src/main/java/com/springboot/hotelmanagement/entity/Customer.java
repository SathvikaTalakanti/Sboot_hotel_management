package com.springboot.hotelmanagement.entity;


import lombok.Data;

import javax.validation.constraints.*;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @NotEmpty(message = "FirstName can not be empty!!")
    @NotNull(message = "FirstName should not be null")
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "LastName can not be empty!!")
    @NotNull(message = "LastName should not be null")
    @Column(name="last_name")
    private String lastName;

    @NotEmpty(message = "Email can not be empty!!")
    @Pattern(regexp="^[a-z0-9]{5,}@gmail.com$", message="not a valid email")
    @Column(name="email")
    private String email;

    @ManyToOne//(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name="hotel_hotel_id")
    private Hotel hotel;

    public Customer(){}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}