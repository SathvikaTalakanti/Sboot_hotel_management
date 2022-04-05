package com.springboot.hotelmanagement.controller;


import com.springboot.hotelmanagement.dto.HotelDto;
import com.springboot.hotelmanagement.entity.Customer;
import com.springboot.hotelmanagement.entity.Hotel;
import com.springboot.hotelmanagement.service.CustomerService;
import com.springboot.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HotelService hotelService;

    String customerForm="customers/customer-form";


    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
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
        return customerForm;
    }

    @PostMapping("/save/{Id}")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result, @PathVariable("Id") int theId){

        if(result.hasErrors()) {
            return customerForm;
        }else {
            Hotel theHotel = hotelService.findById(theId);
            theCustomer.setHotel(theHotel);
            customerService.save(theCustomer);
            return "redirect:/customers/findCustomers?hotelId=" + theId;
        }
    }

    @GetMapping("/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int theId,@RequestParam("hotelId") int hotelId, Model theModel){
        Customer theCustomer= customerService.findById(theId);
        theModel.addAttribute(theCustomer);
        theModel.addAttribute("hotelId",hotelId);
        return customerForm;
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