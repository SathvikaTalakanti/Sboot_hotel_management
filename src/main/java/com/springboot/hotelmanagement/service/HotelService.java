package com.springboot.hotelmanagement.service;


import com.springboot.hotelmanagement.entity.Hotel;

import java.util.List;

public interface HotelService{
    public List<Hotel> findAll();

    public Hotel findById(int theId);

    public void save(Hotel theHotel);

    public void deleteById(int theId);
}