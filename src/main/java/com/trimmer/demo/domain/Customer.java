package com.trimmer.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@Data
@AllArgsConstructor
@NamedQuery(name = "Customer.withAddressNamedQuery", query =
        "select c from Customer c where c.address=?1")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;

    public Customer() {}
}
