package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderCode;
    private String orderName;
    private Double orderScore;
    private int scorePayId;
    private int orderPay;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}