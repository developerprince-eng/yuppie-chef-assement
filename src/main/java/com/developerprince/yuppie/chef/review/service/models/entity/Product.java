package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "name",columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "dimensions",columnDefinition = "VARCHAR(64)")
    private String dimensions;

    @Column(name = "model_type",columnDefinition = "VARCHAR(196)")
    private String modelType;

    @Column(name = "weight",columnDefinition = "VARCHAR(32)")
    private String weight;

    @Column(name = "color",columnDefinition = "VARCHAR(196)")
    private String color;

    @Column(name = "image_url",columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "store_id",columnDefinition = "BIGINT")
    private Long storeId;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "product_category_fk",
                    foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES category(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Category> categories;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "review_product_fk",
                    foreignKeyDefinition = "FOREIGN KEY (review_id) REFERENCES review(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Review> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", updatable = false, insertable = false)
    private Store store;
}
