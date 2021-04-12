package chanjy.exception;



import chanjy.result.CodeMsg;
import chanjy.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandle(HttpServletRequest request,Exception e){
        if(e instanceof GlobalException){
            GlobalException ex =(GlobalException)e;
            return Result.error(ex.getCm());
        }else {
            e.printStackTrace();
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
