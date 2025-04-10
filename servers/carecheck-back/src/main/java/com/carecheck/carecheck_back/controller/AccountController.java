package com.carecheck.carecheck_back.controller;

import com.carecheck.carecheck_back.entity.User;
import com.carecheck.carecheck_back.security.principal.PrincipalUser;
import com.carecheck.carecheck_back.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/account/users")
public class AccountController {

    @Autowired
    private UserService userService;

    @Operation(summary = "개인 정보 수정(비밀번호)", description = "내 정보 화면 - 비밀번호 수정")
    @PutMapping("/password")
    public ResponseEntity<?> changePassword(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody Map<String, String> requestBody
    ) throws Exception {

        userService.updatePassword(principalUser, requestBody.get("currentPassword"), requestBody.get("newPassword"));
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "개인 정보 수정(이메일)", description = "내 정보 화면 - 이메일 수정")
    @PutMapping("/email")
    public ResponseEntity<?> changeEmail(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody Map<String, String> requestBody
    ) {
        String newEmail = requestBody.get("email");
        userService.updateEmail(principalUser, newEmail);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "개인 정보 수정(전화번호)", description = "내 정보 화면 - 전화번호 수정")
    @PutMapping("/phone-number")
    public ResponseEntity<?> changePhoneNumber(
            @AuthenticationPrincipal PrincipalUser principalUser,
            @RequestBody Map<String, String> requestBody
    ) {
        String newPhoneNumber = requestBody.get("phoneNumber");
        userService.updatePhoneNumber(principalUser, newPhoneNumber);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "로그인 유저 정보", description = "로그인 유저 정보 불러오기")
    @GetMapping("/me")
    public ResponseEntity<?> getLoginUser(@AuthenticationPrincipal PrincipalUser principalUser) {
        return ResponseEntity.ok().body(principalUser.getUser());
    }


}
