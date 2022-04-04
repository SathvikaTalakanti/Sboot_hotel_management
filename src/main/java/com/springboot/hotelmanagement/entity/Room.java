package com.springboot.hotelmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Integer roomId;

    @Column(name="room_no")
    private Integer roomNo;

    @Column(name="floor_no")
    private Integer floorNo;

    @ManyToOne//(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name="hotel_hotel_id")
    private Hotel hotel;

    public Room(){}

    public Room(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNo=" + roomNo +
                ", floorNo=" + floorNo +
                ", hotel=" + hotel +
                '}';
    }
}