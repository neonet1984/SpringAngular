package com.controller.restController;

import com.controller.model.JsonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(Exception.class)
    public JsonResponse handleError(HttpServletRequest request, Exception e)   {

        return new JsonResponse("",e.toString());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public JsonResponse handleError404(HttpServletRequest request, Exception e)  {
        return new JsonResponse("404",e.getMessage());
    }


}
