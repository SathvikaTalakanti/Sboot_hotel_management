package com.springboot.hotelmanagement.service;

import com.springboot.hotelmanagement.entity.Customer;
import com.springboot.hotelmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer findById(int theId) {
        Optional<Customer>  result = customerRepository.findById(theId);

        Customer theCustomer=null;
        if(result.isPresent()){
            theCustomer= result.get();
        }else{
            throw new RuntimeException("The Given Customer Id " + theId + "is not Present");
        }
        return theCustomer;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Customer> findCustomers(int theId) {
        return customerRepository.findCustomers(theId);
    }


}