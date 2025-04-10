package com.carecheck.carecheck_back.repository;

import com.carecheck.carecheck_back.entity.Order;
import com.carecheck.carecheck_back.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderMapper orderMapper;

    public void insert(Order order) {
        orderMapper.insertOrder(order);
    }

    public Optional<List<Order>> findAllByNameContaining(String orderName) {
        return orderMapper.selectAllByOrderNameContaining(orderName).isEmpty()
                ? Optional.empty()
                : Optional.of(orderMapper.selectAllByOrderNameContaining(orderName));
    }

    public void updateScorePay(double scorePay) {
        orderMapper.updateScoreById(scorePay);
    };

    public void insertScorePay(double scorePay) {
        orderMapper.insertScorePay(scorePay);
    }
}
