package com.carecheck.carecheck_back.security.principal;

import com.carecheck.carecheck_back.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class PrincipalUser implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getUserRole().getRole().getRoleName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountExpired() == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountLocked() == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsExpired() == 1;
    }

    @Override
    public boolean isEnabled() {
        return user.getAccountEnabled() == 1;
    }

    public String getUsercode() {
        return user.getUsercode();
    }
}