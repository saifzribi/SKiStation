package tn.esprit.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private typeCours typecours;
    @Enumerated(EnumType.STRING)
    private Support support;
    private float prix;
    private int creneau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="cour")
    private Set<Inscription> inscriptions;



}
