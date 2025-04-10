package com.carecheck.carecheck_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int index;
    private String username;
    private String usercode;
    @JsonIgnore
    private String password;
    private String email;
    private String phoneNumber;
    private int accountExpired;
    private int accountLocked;
    private int credentialsExpired;
    private int accountEnabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdAtDateFormat;
    private String updatedAtDateFormat;
    private UserRole userRole;
}
