package com.codervibe.springbootfileuploaddemo.service;

import com.codervibe.springbootfileuploaddemo.model.Resp;
import com.codervibe.springbootfileuploaddemo.model.User;

public interface LoginService {
    /**
     * 用户登录
     * @param user
     * @return Resp<String>
     */
   Resp<String> login(User user);
}
