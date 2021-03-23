package chanjy.config;

import chanjy.pojo.Customer;
import chanjy.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private LoginServiceImpl loginService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz== Customer.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

            HttpServletRequest request= webRequest.getNativeRequest(HttpServletRequest.class);
            HttpServletResponse response=webRequest.getNativeResponse(HttpServletResponse.class);
            Customer customer = getUser(request,response);
            return customer;

    }

    private Customer getUser(HttpServletRequest request,HttpServletResponse response){
        String cookieToken = loginService.getCookieValue(request,loginService.COOKIE_NAME_TOKEN);
        if(cookieToken==null) return null;
        return loginService.getByToken(response,cookieToken);
    }
}
