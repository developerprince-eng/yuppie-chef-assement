package com.developerprince.yuppie.chef.review.service.exceptions;

public class NoAvailableResourceException extends NullPointerException {
    private static final long serialVersionUID = 7718828512143293558L;

    public NoAvailableResourceException(String errorMessage){
        super(errorMessage);
    }

}
