package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RequiredArgsConstructor
@Entity
@Getter
@Setter
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String productName;
    private String description;
    private String creator;
    private String category;
    private String genre;
    private String dimensions;
    private int quantityRemainingInStock;



}
