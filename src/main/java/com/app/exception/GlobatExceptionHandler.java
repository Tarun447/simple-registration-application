package com.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


// extendds ResponseEntityExceptionHandler is use for handle all validation exception

@ControllerAdvice
public class GlobatExceptionHandler  extends ResponseEntityExceptionHandler {



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFounddException(UserNotFoundException userNotFoundException){
        ErrorDetails errorDetails= new ErrorDetails(userNotFoundException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserAlreadyPresentException.class)
    public ResponseEntity<ErrorDetails> handleUserAlreadyPresentException(UserAlreadyPresentException exception)
    {
        ErrorDetails errorDetails =  new ErrorDetails(exception.getMessage());
        return  new ResponseEntity<>(errorDetails,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception exception)
    {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> errors = new HashMap<>();

        List<ObjectError> list = ex.getBindingResult().getAllErrors();
        list.forEach((err)->{
            String filedName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            errors.put(filedName,message);
        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ErrorDetails> passwordNotMatchException(PasswordNotMatchException exception){
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage());
        return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_ACCEPTABLE);
    }
}
