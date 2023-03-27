package com.mypayapp.repository;

import com.mypayapp.entity.PaymentMethod;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod,Integer> {


    @Query(value = "SELECT " +
            "pm.id," + //0
            "pm.expire_date," + //1
            "pm.card_number," +//2
            "c.name," +//3
            "c.address," + //4
            "o.order_date," +//5
            "o.total_price " +//6
            "from customer c " +
            "INNER JOIN payment_methods pm ON pm.customer_id= c.id " +
            "INNER JOIN orders o ON o.customer_id = c.id"

            ,countQuery = "select count(pm.id) as count " +
            "from customer c " +
            "INNER JOIN payment_methods pm ON pm.customer_id= c.id " +
            "INNER JOIN orders o ON o.customer_id = c.id"

            ,nativeQuery = true)
    Page<Object[]> getPaymentDetails(Pageable pageable);
}
