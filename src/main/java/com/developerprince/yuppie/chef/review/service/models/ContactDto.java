package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ContactDto {
    private Long id;
    @NotEmpty
    private String emailAddress;
    @NotEmpty
    private String mobile;
    private String telephone;
}
