package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(columnDefinition = "CHARACTER VARYING(255) NOT NULL")
    private String name;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "permission_role_fk",
                    foreignKeyDefinition = "FOREIGN KEY (permission_id) REFERENCES permission(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Permission> permissions;
}