package com.jq.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jq.constant.Constant;
import com.jq.vo.SysResult;

/**
 * Desc:全局异常捕获并返回
 *
 */

@RestController
@ControllerAdvice
public class ExceptionHandlerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception e)
            throws Exception {
    	ModelAndView modelAndView = new ModelAndView();
    	logger.error("catch exception, e=[" + e.getMessage() + "]");
    	modelAndView.setViewName("allerror");
        return modelAndView;
    }
}