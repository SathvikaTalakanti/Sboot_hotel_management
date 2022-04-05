package com.springboot.hotelmanagement.dto;

import com.springboot.hotelmanagement.entity.Hotel;
import lombok.Data;

@Data
public class HotelDto {

    private String hotelName;

    private String hotelAddress;

}