package org.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "compte")
@Getter @Setter
public class CompteEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    @Column(name = "code_postal")
    private Integer codePostal;
    private String ville;
    @Column(name = "num_portable")
    private Integer numPortable;
    @Column(name = "num_domicile")
    private Integer numDomicile;
    @Column(name = "num_carte_bibliotheque")
    private Integer numCarteBibliotheque;
    private String mail;
    @Column(name = "mot_de_passe")
    private String motDePasse;

    @OneToMany(mappedBy = "compte")
    private Collection<EmpruntEntity> emprunts;

    public CompteEntity() {
    }

    public CompteEntity(String nom, String prenom, String adresse, Integer codePostal,
                        String ville, Integer numPortable, Integer numDomicile, Integer numCarteBibliotheque,
                        String mail, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.numPortable = numPortable;
        this.numDomicile = numDomicile;
        this.numCarteBibliotheque = numCarteBibliotheque;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public CompteEntity(CompteEntity compteEntity){

    }

}
