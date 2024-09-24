package tn.esprit.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table( name ="Skieur")
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String ville;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Piste> pistes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="skieur")
    @JsonIgnore
    private Set<Inscription> inscriptions;
    @OneToOne
    //@JsonIgnore
    private Abonnement abonnement;
}
