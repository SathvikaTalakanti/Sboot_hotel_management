package com.springboot.hotelmanagement.controller;

import com.springboot.hotelmanagement.entity.Hotel;
import com.springboot.hotelmanagement.entity.Room;
import com.springboot.hotelmanagement.service.HotelService;
import com.springboot.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public HotelService hotelService;

    @Autowired
    public RoomController(RoomService theRoomService){
        roomService=theRoomService;
    }

    @GetMapping("showAll")
    public String findAll(Model theModel){
        List<Room> Rooms= roomService.findAll();
        theModel.addAttribute("rooms",Rooms);
        return "rooms/showRooms";
    }

    @GetMapping("/showFormForAdd/{Id}")
    public String showFormForAdd(Model theModel,@PathVariable int Id){
        Room theRoom= new Room();
        theModel.addAttribute("room",theRoom);
        theModel.addAttribute("hotelId",Id);
        return "rooms/room-form";
    }

    @PostMapping("/save/{Id}")
    public String saveRoom(@ModelAttribute("room") Room theRoom,@PathVariable int Id){
        Hotel theHotel= hotelService.findById(Id);
        theRoom.setHotel(theHotel);
        roomService.save(theRoom);
        return "redirect:/rooms/findRooms?hotelId="+Id;
    }

    @GetMapping("/showFormForUpdate")
    public String updateRoom(@RequestParam("roomId") int theId,@RequestParam("hotelId") int Id ,Model theModel){
        Room theRoom = roomService.findById(theId);
        theModel.addAttribute(theRoom);
        theModel.addAttribute("hotelId", Id);
        return "rooms/room-form";
    }

    @GetMapping("/deleteById")
    public String deleteRoom(@RequestParam("roomId") int theId,@RequestParam("hotelId") int Id ){
        roomService.deleteById(theId);
        return "redirect:/rooms/findRooms?hotelId="+Id;
    }

    @GetMapping("/findRooms")
    public String findRooms(@RequestParam("hotelId") int theId, Model theModel){
        List<Room> Rooms=roomService.findRooms(theId);
        theModel.addAttribute("hotelRooms",Rooms);
        theModel.addAttribute("hotelId",theId);
        return "rooms/showRooms";
    }

}