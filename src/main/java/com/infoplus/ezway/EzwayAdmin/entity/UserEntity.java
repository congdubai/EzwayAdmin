package com.infoplus.ezway.EzwayAdmin.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class UserEntity implements UserDetails {

    private Integer id;
    private String email;
    private String password;
    private int pin;
    private String host;
    private Role role;
    private int visit;
    private boolean banned = false;
    private String fullName;
    private String department;
    private String employeeId;
    private String telNumber;
    private String authority;
    private String status;
    private String branch;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {

        return employeeId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !banned;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
