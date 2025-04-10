package com.carecheck.carecheck_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carecheck.carecheck_back.service.UserRoleService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @Operation(summary = "권한id로 의사코드, 이름 조회.", description = "권한id입력으로 usercode, name 조회")
    @GetMapping
    public ResponseEntity<?> selectUsercodeByRoleId (
        @RequestParam int roleId) throws Exception{
        return ResponseEntity.ok().body(userRoleService.selectUserCodyByRoleId(roleId));
    }
}
