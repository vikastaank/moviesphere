package com.vtworks.moviesphere.core.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtworks.moviesphere.core.basic.ResultVO;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
    public static final String RESPONSE_FAILURE = "FAILURE";

    @ExceptionHandler(MovieSphereException.class)
    public ResultVO<Object> handleNotFoundException(MovieSphereException ex) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setStatus(RESPONSE_FAILURE);
        resultVO.setStatusCode(500);
        resultVO.setStatusMsg(ex.getMessage());
        ex.printStackTrace();
        return resultVO;
    }

}