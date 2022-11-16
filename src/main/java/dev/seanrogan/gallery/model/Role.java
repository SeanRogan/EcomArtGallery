package dev.seanrogan.gallery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
}
