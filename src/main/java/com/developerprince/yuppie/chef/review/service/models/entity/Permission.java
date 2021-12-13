package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="permission")
@Data
public class Permission implements Serializable{
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(columnDefinition = "CHARACTER VARYING(255) NOT NULL")
    private String name;

}
