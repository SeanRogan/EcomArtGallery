package dev.seanrogan.gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.Set;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class ShoppingCart {
    //cart id number
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    //the user associated with the cart
    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private User user;

    //the set of products in the cart
    @Column(name = "cart_contents")
    @OneToMany
    private Set<CartItem> productsInCart;

    @Column(name = "item_qty")
    private int numberOfItemsInCart;
    //the date the cart was last updated/created
    @Column(name = "created_date")
    private Date createdDate;

}
