package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "name",columnDefinition = "VARCHAR(196) NOT NULL")
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
}
