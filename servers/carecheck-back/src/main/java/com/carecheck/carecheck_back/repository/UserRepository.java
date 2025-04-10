package com.carecheck.carecheck_back.repository;

import com.carecheck.carecheck_back.entity.User;
import com.carecheck.carecheck_back.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public Optional<User> selectById(int userId) {
        return Optional.ofNullable(userMapper.selectById(userId));
    }

    public Optional<User> selectByUsercode(String usercode) {
        return Optional.ofNullable(userMapper.selectByUsercode(usercode));
    }

    public String selectUsercode(int roleId) {
        return userMapper.selectUsercode(roleId);
    }

    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }
    public void updatePassword(String usercode, String password) {
        userMapper.updatePasswordByCode(usercode, password);
    }
    public void updateEmail(String usercode, String email) {
        userMapper.updateEmailByCode(usercode, email);
    }
    public void updatePhoneNumber(String usercode, String phoneNumber) {
        userMapper.updatePhoneNumberByCode(usercode, phoneNumber);
    }

    public List<User> selectUserListAllBySearchOption(
            int startIndex,
            int limitCount,
            String order,
            String searchName) {
        List<User> foundUser = userMapper.selectUserListBySearchOptions(startIndex, limitCount, order, searchName);
        return foundUser;
    }

    public int selectUserListCountAllBySearchName(String searchName) {
        return userMapper.selectUserCountAllBySearchName(searchName);
    }

    public void updateUserByCode(User user) {
        userMapper.updateUserByCode(user);
    }
    public void updateUserPasswordByCode(String usercode, String password) {
        userMapper.updateUserPasswordByCode(usercode, password);
    }
    public void updateUserAccountByCode(String usercode) {
        userMapper.updateUserAccountByCode(usercode);
    }

}
