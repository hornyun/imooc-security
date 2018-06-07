package com.imooc.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
@Entity
public class User implements Serializable ,UserDetails{
    private static final long serialVersionUID = -5702788659357835068L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private String username;

    private String password;

    @Column(name = "client_id")
    private String clientId;

    private Integer status;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "updated_dt")
    private Date updatedDt;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
