package com.springboot.hotelmanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class HotelManagementApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }



    public static void main(String[] args) {
        SpringApplication.run(HotelManagementApplication.class, args);
    }

}