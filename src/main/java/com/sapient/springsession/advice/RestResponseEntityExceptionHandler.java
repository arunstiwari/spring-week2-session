package com.sapient.springsession.advice;

import com.sapient.springsession.exception.ProductNotFoundException;
import com.sapient.springsession.model.ErrorResponse;
import com.sapient.springsession.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleException(RuntimeException exception, WebRequest request){
        log.error(" exception : {}",exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setInstance("product/id");
        errorResponse.setTitle(exception.getMessage());
        errorResponse.setType(String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ProductNotFoundException.class})
    protected ResponseEntity<Object> handleProductNotFound(ProductNotFoundException exception, WebRequest request){
        log.error(" exception : {}",exception.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setInstance("product/id");
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setTitle("Searching the Product Not found");
        errorResponse.setType(String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//        @ExceptionHandler(value = {ProductNotFoundException.class})
//    protected ResponseEntity<Object> handleException(ProductNotFoundException exception, WebRequest request){
//        log.error(" exception : {}",exception.getMessage());
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setInstance("");
//        errorResponse.setTitle("Searching the Product");
//        errorResponse.setType(String.valueOf(HttpStatus.NOT_FOUND.value()));
//       return handleExceptionInternal()
//    }
}
