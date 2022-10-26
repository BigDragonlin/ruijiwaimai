package com.furuitakeout.common;

import com.furuitakeout.common.myException.CustomerException;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 处理异常类
 */
@ControllerAdvice(annotations = {Controller.class, Service.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获异常
     * SQLIntegrityConstraintViolationException.class捕获的异常
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception){
        log.info("进入exceptionHandler++》{}",exception.getMessage());

        if (exception.getMessage().contains("Duplicate entry")){
            final String[] s = exception.getMessage().split(" ");
            final String s1 = s[2] + "已存在";
            log.info("多次提交一个员工的错误==》{}",s1);
            return R.error(s1);
        }
        return R.error("未知错误");
    }

    /**
     * 捕获自定义异常 CustomerException
     * @param exception
     * @return
     */
    @ExceptionHandler(CustomerException.class)
    public R<String> customerException(CustomerException exception){
        //报错日志
        log.error(exception.getMessage());
        return R.error(exception.getMessage());
    }

}
