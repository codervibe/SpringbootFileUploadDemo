package com.codervibe.springbootfileuploaddemo.controller;


import com.codervibe.springbootfileuploaddemo.model.Resp;
import com.codervibe.springbootfileuploaddemo.model.User;
import com.codervibe.springbootfileuploaddemo.service.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class LoginController {
    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Resp<String> userLogin(@RequestBody User user){
        log.info("User = "+user.toString());

        return loginService.login(user);
    }
}
