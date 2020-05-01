package com.cg.RestServices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)   //404 Not Found
public class UserNotFound extends RuntimeException {

	 

    public UserNotFound(String msg) {
        super(msg);
    }

 

}
 