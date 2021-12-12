package com.developerprince.yuppie.chef.review.service.exceptions;

import java.util.NoSuchElementException;

public class NoSuchResourceException extends NoSuchElementException {
    public NoSuchResourceException(String errorMessage){
        super(errorMessage);
    }
}