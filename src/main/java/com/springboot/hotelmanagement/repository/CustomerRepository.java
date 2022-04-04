package com.springboot.hotelmanagement.repository;

import com.springboot.hotelmanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //no code required
    @Query(value="select * from customer where hotel_hotel_id=:hotelId", nativeQuery=true)
    List<Customer> findCustomers(@Param("hotelId") int theId);


}