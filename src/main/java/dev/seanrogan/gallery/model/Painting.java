package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Painting extends Product{
    //what kind of paint (oil, watercolor, etc)
    private String medium;
    //what kind of canvas(cotton canvas, wood panel, etc)
    private String material;

}
