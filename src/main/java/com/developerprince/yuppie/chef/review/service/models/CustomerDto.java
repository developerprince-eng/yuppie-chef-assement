package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
public class CustomerDto {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private Date dob;
    private Set<AddressDto> addresses;
    @NotEmpty
    private Set<ContactDto> contacts;
}
