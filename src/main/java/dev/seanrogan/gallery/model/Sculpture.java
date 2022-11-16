package dev.seanrogan.gallery.model;

import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;

@RequiredArgsConstructor
@Entity
public class Sculpture extends Product{

    private String material;
    private float weight;


}
