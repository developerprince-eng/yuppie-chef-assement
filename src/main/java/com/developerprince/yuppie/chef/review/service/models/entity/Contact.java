package com.developerprince.yuppie.chef.review.service.models.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="contact")
@Data
public class Contact implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "email_address",columnDefinition = "CHARACTER VARYING(255)")
    private String emailAddress;

    @Column(name = "mobile",columnDefinition = "CHARACTER VARYING(16)")
    private String mobile;

    @Column(name = "telephone",columnDefinition = "CHARACTER VARYING(16)")
    private String telephone;
}
