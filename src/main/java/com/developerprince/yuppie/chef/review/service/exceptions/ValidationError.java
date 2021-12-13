package com.developerprince.yuppie.chef.review.service.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ValidationError {
    private final String field;
    private final String message;
}