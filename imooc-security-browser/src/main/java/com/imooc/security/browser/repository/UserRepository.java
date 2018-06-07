package com.imooc.security.browser.repository;

import com.imooc.security.browser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
