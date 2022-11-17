package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
    @JoinColumn(table = "user" , referencedColumnName = "id")
    private Long ownerId;
    @Temporal(TemporalType.DATE)
    private Date lastLoginDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetAttempt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date memberSince;
    private boolean isSeller;
    @OneToOne
    @MapsId
    private ShoppingCart currentCart;
}
