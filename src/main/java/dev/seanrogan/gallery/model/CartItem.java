package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;
}
