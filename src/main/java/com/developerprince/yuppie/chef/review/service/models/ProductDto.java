package com.developerprince.yuppie.chef.review.service.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
public class ProductDto {
    @NotEmpty
    private String name;
    private String dimensions;
    private String modelType;
    private String weight;
    private String color;
    @NotEmpty
    private Set<String> categories;
}
