package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.dto.request.ReqAddOrderDto;
import com.carecheck.carecheck_back.dto.request.ReqSearchOrderDto;
import com.carecheck.carecheck_back.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "오더등록", description = "오더등록")
    @PostMapping("")
    public ResponseEntity<?> orderEnroll(@RequestBody ReqAddOrderDto reqAddOrderDto) {
        orderService.save(reqAddOrderDto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "오더검색", description = "오더명검색")
    @GetMapping("/list")
    public ResponseEntity<?> searchOrder(@ModelAttribute ReqSearchOrderDto reqSearchOrderDto) throws Exception {
        return ResponseEntity.ok().body(orderService.getAllOrders(reqSearchOrderDto));
    }
}

