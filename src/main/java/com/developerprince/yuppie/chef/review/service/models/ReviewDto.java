package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ReviewDto {
    private Long id;
    @NotEmpty
    private String description;
    private Short rating;
    private CustomerDto customer;
    private Long storeId;
}
