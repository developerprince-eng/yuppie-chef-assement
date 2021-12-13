package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StoreUserFk implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    private Long storeId;
    private Long userId;
}
