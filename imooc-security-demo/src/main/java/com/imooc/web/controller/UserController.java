package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.domain.User;
import com.imooc.web.form.UserQueryCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/user")
    @JsonView(User.UserDetailView.class)
    public Map<String, Object> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                log.info("[objectError.getDefaultMessage()={}]", objectError.getDefaultMessage());
            }
        }
        log.info("【create user as 】={}", user);
        log.info("【user'id is null.Answer:{}】", (user.getId() == null));
        Map<String, Object> result = new HashMap<>(4);
        result.put("message", "success");
        result.put("status", "0");
        return result;
    }

    @PutMapping("/user/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + error.getDefaultMessage();
                log.info("【update user exception message:{}】", message);
            });
        }
        log.info("【update User = {}】", user);
        return new User("update", "update");
    }

    @DeleteMapping("/user/{id:\\d+}")
    public void delete(@PathVariable String id) {
        log.info("【delete user where id = {}】", id);
    }
}
