package com.springboot.hotelmanagement.service;

import com.springboot.hotelmanagement.dto.HotelDto;
import com.springboot.hotelmanagement.entity.Hotel;
import com.springboot.hotelmanagement.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    @Transactional
    public Hotel findById(int theId) {
        Optional<Hotel> result= hotelRepository.findById(theId);

        Hotel theHotel=null;
        if (result.isPresent()) {
            theHotel=result.get();
        }else{
            throw new RuntimeException("The Hotel with given Id" + theId + "is not present in the database");
        }
        return theHotel;
    }

    @Override
    @Transactional
    public void save(Hotel theHotel) {
        hotelRepository.save(theHotel);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        hotelRepository.deleteById(theId);
    }

    public List<HotelDto> getAllHotels(){
        return hotelRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private HotelDto convertEntityToDto(Hotel hotel){
        HotelDto hotelDto=new HotelDto();
        hotelDto=modelMapper.map(hotel, HotelDto.class);
        return hotelDto;
    }

}