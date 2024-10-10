package com.orderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderService.entity.MyOrder;
@Repository
public interface OrderRepo extends JpaRepository<MyOrder, Integer>{

}
