package dev.seanrogan.gallery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Print extends Product{
    //what material its printed on
    private String material;
    //limited edition or open?
    private boolean limitedEdition;

}
