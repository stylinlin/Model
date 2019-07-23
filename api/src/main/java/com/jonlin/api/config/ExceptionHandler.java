package com.jonlin.api.config;

import com.jonlin.common.BaseException;
import com.jonlin.common.ResultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * description 全局异常处理
 * Author Jonlin
 * Date 2019/3/7 10:57
 **/
@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseBody
    public Object handler(Exception e) {
        LOGGER.error("Exception:{}", e.getMessage(), e); // 打印 并 存储日志文件
        StringBuilder errorBuilder = new StringBuilder();
        if (e instanceof NoHandlerFoundException) { // 404处理 **********************************************
            NoHandlerFoundException noHandlerFoundException = (NoHandlerFoundException) e;
            String url = noHandlerFoundException.getRequestURL();
//            String httpMethod = noHandlerFoundException.getHttpMethod();
            errorBuilder.append("请求地址不存在：" + url);
            return new ResponseEntity(ResultResponse.fail(errorBuilder.toString()), HttpStatus.NOT_FOUND);
        } else if (e instanceof BindException) {  // 处理参数类型错误**************************************************
            BindingResult bindingResult = ((BindException) e).getBindingResult();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            errorBuilder.append("参数错误：");
            for (int i = 0; i < fieldErrors.size(); i++) {
                FieldError fieldError = fieldErrors.get(i);
                String field = fieldError.getField();
                Object value = fieldError.getRejectedValue();
                errorBuilder.append("参数名<" + field + ">不能接收参数值<" + value + ">\n");
            }
            errorBuilder.delete(errorBuilder.lastIndexOf("\n"), errorBuilder.length());
            return new ResponseEntity(ResultResponse.fail(errorBuilder.toString()),
                    HttpStatus.BAD_REQUEST);
        } else if (e instanceof BaseException) { // 处理自定义错误**********************************************
            errorBuilder.append("捕获异常：" + e.getMessage());
            return new ResponseEntity(ResultResponse.fail(errorBuilder.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
        } else { // 处理未知错误*********************************************************
            errorBuilder.append("异常信息：" + e.getMessage());
            return new ResponseEntity(ResultResponse.fail(errorBuilder.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
