package com.codervibe.springbootfileuploaddemo.service.Impl;

import com.codervibe.springbootfileuploaddemo.mapper.LoginDao;
import com.codervibe.springbootfileuploaddemo.model.Resp;
import com.codervibe.springbootfileuploaddemo.model.User;
import com.codervibe.springbootfileuploaddemo.service.LoginService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;
    private Log log = LogFactory.getLog(this.getClass());
    /**
     * 用户登录
     * @param user
     * @return Resp<String>
     */
    @Override
    public Resp<String> login(User user) {
        log.info("user"+user.toString());
        try {
            User resultuser=loginDao.userLogin(user);
            log.info("resultuser"+resultuser.toString());
            return Resp.success("OK");
        }catch (Exception e) {
            return Resp.fail("500",e.getMessage());
        }
    }
}
