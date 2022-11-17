package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Sculpture extends Product{
    //what is it made of (stone, wood, ceramic, etc)
    private String material;
    private float weight;

}
