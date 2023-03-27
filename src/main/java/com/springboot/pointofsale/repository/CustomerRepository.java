package com.mypayapp.repository;

import com.mypayapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByMobile(int mobile);

    Customer existsCustomerByMobile(int mobile);


    boolean existsByMobileAndIsRegisteredEquals(int mobile,int i);

    boolean existsByMobileEqualsAndOtpEquals(int mobile, int otp);

    Customer getByMobile(int mobile);
}
