package com.carecheck.carecheck_back.service;

import com.carecheck.carecheck_back.dto.request.ReqAddOrderDto;
import com.carecheck.carecheck_back.dto.request.ReqSearchOrderDto;
import com.carecheck.carecheck_back.entity.Order;
import com.carecheck.carecheck_back.repository.OrderRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(ReqAddOrderDto reqAddOrderDto) {
        Order order = Order.builder()
                .orderCode(reqAddOrderDto.getOrderCode())
                .orderName(reqAddOrderDto.getOrderName())
                .orderScore(reqAddOrderDto.getOrderScore())
                .build();
        orderRepository.insert(order);
    }

    public List<Order> getAllOrders(ReqSearchOrderDto reqSearchOrderDto) throws Exception {
        return orderRepository.findAllByNameContaining(reqSearchOrderDto.getKeyword())
                .orElseThrow(() -> new NotFoundException("조회된 Order가 없습니다."));
    }

    public void updateScorePay(double scorePay) {
        orderRepository.updateScorePay(scorePay);
    }
    public void insertScorePay(double scorePay) {
        orderRepository.insertScorePay(scorePay);
    }

}
