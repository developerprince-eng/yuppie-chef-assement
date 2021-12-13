package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="store")
@Data
public class Store implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", columnDefinition = "VARCHAR(196) NOT NULL")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "store_address_fk",
                    foreignKeyDefinition = "FOREIGN KEY (address_id) REFERENCES address(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;
}
