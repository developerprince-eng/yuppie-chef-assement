package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "review_history")
@Data
@IdClass(ReviewHistoryFk.class)
public class ReviewHistory implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @Column(name = "customer_id", columnDefinition = "BIGINT NOT NULL")
    private Long customerId;

    @Id
    @Column(name = "review_id", columnDefinition = "BIGINT NOT NULL")
    private Long reviewId;

    @Column(name = "reviewed_date",columnDefinition = "TIMEZONE WITHOUT TIME ZONE")
    private Date reviewedDate;
}
