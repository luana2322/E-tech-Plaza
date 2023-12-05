package com.admin_module.config;

import com.example.core_module.model.Admin;
import com.example.core_module.model.Admin_Role;
import com.example.core_module.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminDetails implements UserDetails {
    private Admin admin;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for(Admin_Role role:admin.getList_admin_role()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getRole_name()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return admin.getEmail();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return admin.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
