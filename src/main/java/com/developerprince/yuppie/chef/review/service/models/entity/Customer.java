package com.developerprince.yuppie.chef.review.service.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
    private static final long serialVersionUID = 2166984451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGSERIAL")
    private Long id;

    @Column(name = "first_name",columnDefinition = "CHARACTER VARYING(255)")
    private String firstName;

    @Column(name = "last_name",columnDefinition = "CHARACTER VARYING(255)")
    private String lastName;

    @Column(columnDefinition = "TIMEZONE WITHOUT TIME ZONE")
    private Date dob;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "customer_address_fk",
                    foreignKeyDefinition = "FOREIGN KEY (address_id) REFERENCES address(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, updatable = false, insertable = false,
            foreignKey = @ForeignKey(name = "customer_contact_fk",
                    foreignKeyDefinition = "FOREIGN KEY (contact_id) REFERENCES contact(id)"
            ))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Contact> contacts;

}
