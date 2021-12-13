package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="address")
@Data
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
