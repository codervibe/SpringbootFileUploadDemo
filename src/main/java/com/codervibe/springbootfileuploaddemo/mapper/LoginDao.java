package com.codervibe.springbootfileuploaddemo.mapper;

import com.codervibe.springbootfileuploaddemo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface LoginDao {
    /**
     * 用户登录
     * @param user
     * @return User
     */
    User userLogin(User user);
}
