package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.dto.request.ReqSigninDto;
import com.carecheck.carecheck_back.dto.response.RespTokenDto;
import com.carecheck.carecheck_back.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody ReqSigninDto dto) throws Exception {
        RespTokenDto respTokenDto = RespTokenDto.builder()
                .type("JWT")
                .name("AccessToken")
                .token(userService.signin(dto))
                .build();

        return ResponseEntity.ok().body(respTokenDto);
    }
}
