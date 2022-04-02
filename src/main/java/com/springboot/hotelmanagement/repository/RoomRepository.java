package com.springboot.hotelmanagement.repository;

import com.springboot.hotelmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query(value="select * from room where hotel_hotel_id=:hotelId",nativeQuery = true)
    List<Room> findRooms(@Param("hotelId") int theId);
    //no code required
}