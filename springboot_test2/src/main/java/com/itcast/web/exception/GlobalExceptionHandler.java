package com.itcast.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2019-04-29
 * Time: 8:32
 */
//@ControllerAdvice//切面
//public class GlobalExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)//捕获运行时异常
//    @ResponseBody
//    public Map<String,Object> exceptionHander(){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("errorCode", "101");
//        map.put("errorMsg", "系統错误!");
//        return map;
//    }
//}
