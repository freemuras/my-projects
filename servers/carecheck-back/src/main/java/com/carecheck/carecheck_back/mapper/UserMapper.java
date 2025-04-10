package com.carecheck.carecheck_back.mapper;

import com.carecheck.carecheck_back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User selectById(int userId);
    User selectByUsername(String username);

    User selectByUsercode(String usercode);

    String selectUsercode(int roleId);
    int insert(User user);

    int updatePasswordByCode(
            @Param("usercode") String usercode,
            @Param("password") String password
    );
    int updateEmailByCode(
            @Param("usercode") String usercode,
            @Param("email") String email);
    int updatePhoneNumberByCode(
            @Param("usercode") String usercode,
            @Param("phoneNumber") String phoneNumber
    );

    List<User> selectUserListBySearchOptions(
            @Param("startIndex") int startIndex,
            @Param("limitCount") int limitCount,
            @Param("order") String order,
            @Param("searchName") String searchName
    );

    int selectUserCountAllBySearchName(@Param("searchName") String searchName);

    int updateUserByCode(User user);
    int updateUserPasswordByCode(
            @Param("usercode") String usercode,
            @Param("password") String password
    );
    int updateUserAccountByCode(@Param("usercode") String usercode);

}
