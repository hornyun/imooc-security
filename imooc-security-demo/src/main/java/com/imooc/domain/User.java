package com.imooc.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.Serializable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/4
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class User implements Serializable {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    private static final long serialVersionUID = -5653241688972527399L;

    @JsonView(UserSimpleView.class)
    private String username;
    @JsonView(UserDetailView.class)
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
