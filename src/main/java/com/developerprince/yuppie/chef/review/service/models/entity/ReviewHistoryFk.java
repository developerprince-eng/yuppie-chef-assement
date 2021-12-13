package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewHistoryFk implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    private Long customerId;
    private Long reviewId;

}
