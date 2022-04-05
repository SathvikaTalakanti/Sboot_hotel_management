package com.springboot.hotelmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="hotel_id")
    private int hotelId;

    @NotEmpty(message = "Hotel Name can not be empty!!")
    @NotNull(message = "Hotel Name should not be null")
    @Column(name="hotel_name")
    private String hotelName;

    @NotEmpty(message = "Hotel Address can not be empty!!")
    @NotNull(message = "Hotel Address should not be null")
    @Column(name="hotel_address")
    private String hotelAddress;

    @NotNull(message = "Hotel Rating should not be null")
    @Column(name="hotel_rating")
    private Double hotelRating;

    @OneToMany(mappedBy="hotel",cascade=CascadeType.ALL)
    private List<Room> rooms;

    @OneToMany(mappedBy="hotel", cascade=CascadeType.ALL)
    private List<Customer> customers;

    public Hotel(){}

    public Hotel(String hotelName, String hotelAddress, Double hotelRating) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelRating = hotelRating;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public Double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(Double hotelRating) {
        this.hotelRating = hotelRating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", rating='" + hotelRating + '\'' +
                '}';
    }
}