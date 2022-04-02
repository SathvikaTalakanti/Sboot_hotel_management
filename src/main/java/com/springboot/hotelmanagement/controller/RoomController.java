package com.springboot.hotelmanagement.controller;

import com.springboot.hotelmanagement.entity.Room;
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
    public RoomController(RoomService theRoomService){
        roomService=theRoomService;
    }

    @GetMapping("showAll")
    public String findAll(Model theModel){
        List<Room> Rooms= roomService.findAll();
        theModel.addAttribute("rooms",Rooms);
        return "rooms/showRooms";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Room theRoom= new Room();
        theModel.addAttribute("room",theRoom);
        return "rooms/room-form";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("room") Room theRoom){
        roomService.save(theRoom);
        return "redirect:/rooms/showAll";
    }

    @GetMapping("/showFormForUpdate")
    public String updateRoom(@RequestParam("roomId") int theId, Model theModel){
        Room theRoom = roomService.findById(theId);
        theModel.addAttribute(theRoom);
        return "rooms/room-form";
    }

    @GetMapping("/deleteById")
    public String deleteRoom(@RequestParam("roomId") int theId){
        roomService.deleteById(theId);
        return "redirect:/rooms/showAll";
    }

    @GetMapping("/findRooms")
    public String findRooms(@RequestParam("hotelId") int theId, Model theModel){
        List<Room> Rooms=roomService.findRooms(theId);
        theModel.addAttribute("hotelRooms",Rooms);
        return "rooms/showRooms";
    }

}