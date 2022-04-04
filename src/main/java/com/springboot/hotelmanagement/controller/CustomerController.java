package com.springboot.hotelmanagement.controller;

import com.springboot.hotelmanagement.entity.Customer;
import com.springboot.hotelmanagement.entity.Hotel;
import com.springboot.hotelmanagement.service.CustomerService;
import com.springboot.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    private HotelService hotelService;


    @Autowired
    public CustomerController(CustomerService theCustomerService){
        customerService=theCustomerService;
    }

    @GetMapping("/showAll")//not needed
    public String findAll(Model theModel){
        List<Customer> Customers= customerService.findAll();

        theModel.addAttribute("customers", Customers);
        return "customers/showCustomers";
    }

    @GetMapping("/showFormForAdd/{Id}")
    public String addCustomer(Model theModel,@PathVariable("Id") int theId){
        Customer theCustomer= new Customer();
        theModel.addAttribute("customer", theCustomer);
        theModel.addAttribute("hotelId",theId);
        return "customers/customer-form";
    }

    @PostMapping("/save/{Id}")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer,@PathVariable("Id") int theId){
        Hotel theHotel= hotelService.findById(theId);
        theCustomer.setHotel(theHotel);
        customerService.save(theCustomer);
        return "redirect:/customers/findCustomers?hotelId="+theId;
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId,@RequestParam("hotelId") int hotelId, Model theModel){
        System.out.println(hotelId+" "+theId);
        Customer theCustomer= customerService.findById(theId);
        theModel.addAttribute(theCustomer);
        theModel.addAttribute("hotelId",hotelId);
        return "customers/customer-form";
    }

    @GetMapping("/deleteById")
    public String deleteCustomer(@RequestParam("customerId") int customerId,@RequestParam("hotelId") int theId){
        customerService.deleteById(customerId);
        return "redirect:/customers/findCustomers?hotelId="+theId;

    }

    @GetMapping("/findCustomers")
    public String findCustomers(@RequestParam("hotelId") int theId, Model theModel){
        List<Customer> customers= customerService.findCustomers(theId);
        theModel.addAttribute("hotelCustomers",customers);
        theModel.addAttribute("hotelId",theId);
        return "customers/showCustomers";
    }


}