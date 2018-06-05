package com.imooc.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

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
    @MyConstraint(message = "This is my validator")
    private String username;

    @JsonView(UserSimpleView.class)
    private String id;

    @JsonView(UserDetailView.class)
    @NotNull
    private String password;

    @JsonView(UserSimpleView.class)
    @Past
    private Date birthday;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
