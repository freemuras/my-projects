package com.carecheck.carecheck_back.mapper;

import com.carecheck.carecheck_back.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    int insertOrder(Order order);
    List<Order> selectAllByOrderNameContaining(@Param("orderName") String orderName);
    int insertScorePay(double scorePay);
    int updateScoreById(@Param("scorePay") double scorePay);
}
