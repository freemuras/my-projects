package com.carecheck.carecheck_back.service;

import com.carecheck.carecheck_back.dto.request.ReqSearchUserDto;
import com.carecheck.carecheck_back.dto.request.ReqSigninDto;
import com.carecheck.carecheck_back.dto.request.ReqSignupDto;
import com.carecheck.carecheck_back.entity.User;
import com.carecheck.carecheck_back.entity.UserRole;
import com.carecheck.carecheck_back.repository.UserRepository;
import com.carecheck.carecheck_back.repository.UserRoleRepository;
import com.carecheck.carecheck_back.security.jwt.JwtUtil;
import com.carecheck.carecheck_back.security.principal.PrincipalUser;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public String signin(ReqSigninDto reqSigninDto) throws Exception {
        User user = userRepository.selectByUsercode(reqSigninDto.getUsercode())
                .orElseThrow(() -> new UsernameNotFoundException("사용자 정보를 다시 확인하세요."));

        if(user.getAccountEnabled() != 1) {
            throw new BadRequestException("로그인 권한이 없습니다.");
        }

        if(!passwordEncoder.matches(reqSigninDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 다시 확인하세요.");
        }

        Date expires = new Date(new Date().getTime() + 1000 * 60 * 60 * 24 * 7);

        return jwtUtil.generateToken(
                user.getUsercode(),
                Integer.toString(user.getIndex()),
                expires
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public User signup(ReqSignupDto reqSignupDto) {
        String usercode = userRepository.selectUsercode(reqSignupDto.getRoleId());

        User user = User.builder()
                .username(reqSignupDto.getUsername())
                .usercode(usercode)
                .password(passwordEncoder.encode(reqSignupDto.getPassword()))
                .email(reqSignupDto.getEmail())
                .phoneNumber(reqSignupDto.getPhoneNumber())
                .accountExpired(1)
                .accountLocked(1)
                .credentialsExpired(1)
                .accountEnabled(1)
                .build();
        userRepository.insert(user);

        UserRole userRole = UserRole.builder()
                .usercode(user.getUsercode())
                .roleId(reqSignupDto.getRoleId())
                .build();
        userRoleRepository.insert(userRole);

        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(PrincipalUser principalUser, String currentPassword, String newPassword) throws BadRequestException {
        String encodedNewPassword = passwordEncoder.encode(newPassword);

        if(!passwordEncoder.matches(currentPassword, principalUser.getPassword())) {
            throw new BadCredentialsException("사용자의 정보를 조회할 수 없습니다.");
        }
        if(passwordEncoder.matches(currentPassword, encodedNewPassword)) {
            throw new BadRequestException("현재 비밀번호와 새 비밀번호는 같을 수 없습니다.");
        }

        userRepository.updatePassword(principalUser.getUsercode(), encodedNewPassword);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateEmail(PrincipalUser principalUser, String email) {

        userRepository.updateEmail(principalUser.getUsercode(), email);
    }
    public void updatePhoneNumber(PrincipalUser principalUser, String phoneNumber) {

        userRepository.updatePhoneNumber(principalUser.getUsercode(), phoneNumber);
    }

    @Transactional(readOnly = true)
    public List<User> getUserListSearchBySearchOption(ReqSearchUserDto reqSearchUserDto) {
        int startIndex = (reqSearchUserDto.getPage() - 1) * reqSearchUserDto.getLimitCount();
        List<User> foundUser = userRepository.selectUserListAllBySearchOption(
                startIndex,
                reqSearchUserDto.getLimitCount(),
                reqSearchUserDto.getOrder(),
                reqSearchUserDto.getSearchName()
        );
        return foundUser;
    }

    @Transactional(readOnly = true)
    public int getUserListCountBySearchName(String searchName) {
        return userRepository.selectUserListCountAllBySearchName(searchName);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUser(String usercode, Map<String, String> requestBody) throws Exception {
        User enabledUser = userRepository.selectByUsercode(usercode)
                .orElseThrow(NullPointerException::new);
        if(enabledUser.getAccountEnabled() != 1) {
            throw new BadRequestException("퇴사 처리된 직원입니다.");
        }
        User user = User.builder()
                .usercode(usercode)
                .username(requestBody.get("username"))
                .email(requestBody.get("email"))
                .phoneNumber(requestBody.get("phoneNumber"))
                .build();
        userRepository.updateUserByCode(user);
    }
    @Transactional(rollbackFor = Exception.class)
    public void initialPassword(String usercode, String initialPassword) throws Exception {
        User enabledUser = userRepository.selectByUsercode(usercode)
                .orElseThrow(NullPointerException::new);
        if(enabledUser.getAccountEnabled() != 1) {
            throw new BadRequestException("퇴사 처리된 직원입니다.");
        }
        userRepository.updateUserPasswordByCode(usercode, passwordEncoder.encode(initialPassword));
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateUserAccount(String usercode) throws Exception {
        User enabledUser = userRepository.selectByUsercode(usercode)
                .orElseThrow(NullPointerException::new);
        if(enabledUser.getAccountEnabled() != 1) {
            throw new BadRequestException("이미 퇴사 처리된 직원입니다.");
        }
        userRepository.updateUserAccountByCode(usercode);
    }

}
