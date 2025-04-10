package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SystemSettingController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "점수단가 추가", description = "매년 단가 추가가")
    @PostMapping("/orders/score")
    public ResponseEntity<?> insertScorePay(@RequestParam double scorePay) {
        orderService.insertScorePay(scorePay);
        return ResponseEntity.ok().build();
    }
}
