package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Drawing extends Product{
    //what was used to draw(pen, pencil, etc)
    private String medium;
    //what was drawn upon(type of paper, etc)
    private String material;

}
