package com.springboot.hotelmanagement.service;

import com.springboot.hotelmanagement.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findById(int theId);

    public void save(Customer theCustomer);

    public void deleteById(int theId);

    List<Customer> findCustomers(int theId);
}