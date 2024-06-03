package com.example.jpetstore.repository;

import com.example.jpetstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUsername(String username);
    @Query("SELECT o from Order o WHERE o.orderId=:orderId")
    Optional<Order> findByOrderId(int orderId);
}
