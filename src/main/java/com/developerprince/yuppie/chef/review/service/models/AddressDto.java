package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressDto {
    @NotEmpty
    private String street;
    @NotEmpty
    private String addressUnit;
    private String zipCode;
}
