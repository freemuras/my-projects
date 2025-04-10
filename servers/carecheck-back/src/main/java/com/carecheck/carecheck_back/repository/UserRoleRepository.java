package com.carecheck.carecheck_back.repository;

import com.carecheck.carecheck_back.entity.UserRole;
import com.carecheck.carecheck_back.mapper.UserRoleMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public UserRole insert(UserRole userRole) {
        userRoleMapper.insert(userRole);
        return userRole;
    }

    public Optional<List<UserRole>> selectUserCodyByRoleId(int roleId) {
        List<UserRole> usercodeInRoleId = userRoleMapper.selectByRoleId(roleId);
        if(usercodeInRoleId == null) {
            Optional.empty();
        }
        return Optional.of(usercodeInRoleId);
    }
}
