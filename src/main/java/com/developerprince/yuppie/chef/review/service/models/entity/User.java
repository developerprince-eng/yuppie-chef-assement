package com.developerprince.yuppie.chef.review.service.models.entity;


import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="user_store")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "category_id")
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "first_name",columnDefinition = "CHARACTER VARYING(255)")
    private String firstName;

    @Column(name = "last_name",columnDefinition = "CHARACTER VARYING(255)")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "user_role_fk",
                    foreignKeyDefinition = "FOREIGN KEY (role_id) REFERENCES user_role(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "user_address_fk",
                    foreignKeyDefinition = "FOREIGN KEY (address_id) REFERENCES address(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "user_contact_fk",
                    foreignKeyDefinition = "FOREIGN KEY (contact_id) REFERENCES contact(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;
}
