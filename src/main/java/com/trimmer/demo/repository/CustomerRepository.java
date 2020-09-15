package com.trimmer.demo.repository;

import com.trimmer.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAddress(String address);

    Customer findByFirstNameAndAddress(String firstName, String address);

    @Query("select c from Customer c where c.firstName=:firstName and c.address= :address")
    Customer withFirstNameAndAddressQuery(@Param("firstName")String firstName, @Param("address")String address);

    List<Customer> withAddressNamedQuery(String address);
}
