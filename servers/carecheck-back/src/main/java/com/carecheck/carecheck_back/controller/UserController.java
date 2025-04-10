package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.dto.request.ReqSearchUserDto;
import com.carecheck.carecheck_back.dto.request.ReqSignupDto;
import com.carecheck.carecheck_back.dto.response.RespUserListSearchDto;
import com.carecheck.carecheck_back.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "회원가입(사번등록)", description = "사번등록")
    @PostMapping("/users")
    public ResponseEntity<?> signup(@RequestBody ReqSignupDto dto) {
        return ResponseEntity.ok().body(userService.signup(dto));
    }

    @Operation(summary = "직원 정보 조회", description = "관리자 메뉴 - 직원 정보 조회")
    @GetMapping("/users")
    public ResponseEntity<?> getUsers(@ModelAttribute ReqSearchUserDto dto) {
        int totalUserListCount = userService.getUserListCountBySearchName(dto.getSearchName());
        int totalPages = totalUserListCount % dto.getLimitCount() == 0
                ? totalUserListCount / dto.getLimitCount()
                : totalUserListCount / dto.getLimitCount() + 1;

        RespUserListSearchDto respUserListSearchDto =
                RespUserListSearchDto.builder()
                        .page(dto.getPage())
                        .limitCount(dto.getLimitCount())
                        .totalPages(totalPages)
                        .totalElements(totalUserListCount)
                        .isFirstPage(dto.getPage() == 1)
                        .isLastPage(dto.getPage() == totalPages)
                        .userSearchList(userService.getUserListSearchBySearchOption(dto))
                        .build();
        return ResponseEntity.ok().body(respUserListSearchDto);
    }

    @Operation(summary = "직원 정보 수정", description = "관리자 메뉴 - 직원 정보 조회 - 직원 정보 수정")
    @PutMapping("/users/{usercode}")
    public ResponseEntity<?> updateUser(
            @PathVariable String usercode,
            @RequestBody Map<String, String> requestBody
    ) throws Exception {
        userService.updateUser(usercode, requestBody);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "직원 비밀번호 수정", description = "관리자 메뉴 - 직원 정보 조회 - 직원 비밀번호 수정")
    @PutMapping("/users/{usercode}/password")
    public ResponseEntity<?> initialUserPassword(
            @PathVariable String usercode,
            @RequestBody Map<String, String> requestBody
    ) throws Exception {
        String initialPassword = requestBody.get("password");
        userService.initialPassword(usercode, initialPassword);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "직원 퇴사 처리", description = "관리자 메뉴 - 직원 정보 조회 - 직원 퇴사 처리")
    @PutMapping("/users/{usercode}/account")
    public ResponseEntity<?> resignationUser(@PathVariable String usercode) throws Exception {
        userService.updateUserAccount(usercode);
        return ResponseEntity.ok().build();
    }

}