package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(columnDefinition = "CHARACTER VARYING(196) NOT NULL")
    private String street;

    @Column(name = "address_unit",columnDefinition = "CHARACTER VARYING(16) NOT NULL")
    private String addressUnit;

    @Column(name = "zip_code",columnDefinition = "CHARACTER VARYING(196) NOT NULL")
    private String zipCode;

}
