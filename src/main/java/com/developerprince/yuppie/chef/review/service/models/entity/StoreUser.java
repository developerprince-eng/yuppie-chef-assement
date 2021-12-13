package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="store_user")
@IdClass(StoreUserFk.class)
@Data
public class StoreUser implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @Column(name = "store_id", columnDefinition = "BIGINT")
    private Long storeId;

    @Id
    @Column(name = "user_id", columnDefinition = "BIGINT")
    private Long userId;

}
