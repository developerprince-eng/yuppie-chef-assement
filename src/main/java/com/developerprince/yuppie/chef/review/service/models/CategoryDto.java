package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CategoryDto {
    @NotEmpty
    private String name;
}
