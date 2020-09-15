package com.trimmer.demo.controller;

import com.trimmer.demo.domain.Customer;
import com.trimmer.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        Customer savedCusomer = customerRepository.save(customer);
        return savedCusomer;
    }

    @GetMapping("/address")
    public List<Customer> address(String address) {
        List<Customer> customers = customerRepository.findByAddress(address);
        return customers;
    }

    @GetMapping("/firstNameAndAddress")
    public Customer firstNameAndAddress(String firstName, String address) {
        Customer customer = customerRepository.findByFirstNameAndAddress(firstName, address);
        return customer;
    }

    @GetMapping("/firstNameAndAddressQuery")
    public Customer firstNameAndAddressQuery(String firstName, String address) {
        Customer customer = customerRepository.withFirstNameAndAddressQuery(firstName, address);
        return customer;
    }

    @GetMapping("/addressQuery")
    public List<Customer> addressQuery( String address) {
        List<Customer> customers = customerRepository.withAddressNamedQuery(address);
        return customers;
    }

    @GetMapping("/sort")
    public List<Customer> sort() {
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.ASC, "age"));
        return customers;
    }

    @GetMapping("/page")
    public Page<Customer> page() {
        Page<Customer> customerPage = customerRepository.findAll(PageRequest.of(1, 2));
        return customerPage;
    }
}
