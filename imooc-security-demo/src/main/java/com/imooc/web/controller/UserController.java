package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.domain.User;
import com.imooc.web.vo.UserQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/4
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@RestController
@Slf4j
public class UserController {


    @GetMapping(value = "/user")
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(size = 10, page = 1, sort = "age,desc") Pageable pageable) {
        ArrayList<User> userList = new ArrayList<>(4);

        log.info("【username】={}", condition);
        log.info("【pageable】={}", pageable);

        userList.add(new User("root", "123"));
        userList.add(new User("zhy", "888"));
        userList.add(new User("horn", "97"));

        userList.trimToSize();
        return userList;
    }

    @GetMapping(value = "/user/{id:\\d+}")
    public User getUserById(@PathVariable String id) {
        User user = new User();

        user.setUsername("test");
        user.setPassword("test");

        log.info("【Accept id is】={}", id);
        return user;
    }
}
