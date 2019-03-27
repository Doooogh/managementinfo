package com.graduation.info.managementinfo.system.comment;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AllMyExceptionHandler {
    @ExceptionHandler(UnauthorizedException.class) //自定义的异常类
    @ResponseBody
    public ModelAndView handler(UnauthorizedException testExcepetion){
        if (testExcepetion instanceof UnauthorizedException) {
            ModelAndView mv = new ModelAndView("error/noPer");
            return mv;
        }
        return null;
    }
}
