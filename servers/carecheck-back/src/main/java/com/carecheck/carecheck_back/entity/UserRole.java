package com.carecheck.carecheck_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private int userRoleId;
    private String usercode;
    private int roleId;

    private String username;
    private Role role;
}