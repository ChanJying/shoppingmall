package chanjy.service;

import chanjy.vo.LoginVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    boolean register(LoginVo loginVo);

    boolean login(HttpServletRequest request,HttpServletResponse response, LoginVo loginVo, String uuid);


}
