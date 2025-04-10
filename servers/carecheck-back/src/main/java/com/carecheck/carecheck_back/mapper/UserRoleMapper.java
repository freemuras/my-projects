package com.carecheck.carecheck_back.mapper;

import com.carecheck.carecheck_back.entity.UserRole;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    int insert(UserRole userRole);
    List<UserRole> selectByRoleId(int roleId);
}
