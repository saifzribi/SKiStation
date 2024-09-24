package tn.esprit.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table( name ="Piste")
public class Piste implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;
    private int longueur;
    private int pente;

    public Piste() {
    }
    @ManyToMany(mappedBy="pistes",cascade = CascadeType.ALL)
    private Set<Skieur> skieurs;




}
