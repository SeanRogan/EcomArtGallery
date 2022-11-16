package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;
    private Long owner_id;
    @OneToMany
    private Set<CartItem> productsInCart;
}
