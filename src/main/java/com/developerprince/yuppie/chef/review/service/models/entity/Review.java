package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "rating",columnDefinition = "SMALLINT")
    private Short rating;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name ="id",nullable = false,updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "customer_review_fk",
                    foreignKeyDefinition = "FOREIGN KEY (customer_id) REFERENCES customer(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", updatable = false, insertable = false)
    private Store store;
}
