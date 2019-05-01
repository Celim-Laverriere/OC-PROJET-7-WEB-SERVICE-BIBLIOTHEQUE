package org.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "livre")
@Getter @Setter
public class LivreEntity implements Serializable {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ref_bibliotheque")
    private String refBibliotheque;
    @Column(name = "ouvrage_id")
    private Integer ouvrageId;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "livre_id")
   private OuvrageEntity ouvrage;

   @OneToMany(mappedBy = "livre")
   private Collection<EmpruntEntity> emprunts;

    public LivreEntity() {
    }

    public LivreEntity(String refBibliotheque, Integer ouvrageId) {
        this.refBibliotheque = refBibliotheque;
        this.ouvrageId = ouvrageId;
    }

    public LivreEntity(OuvrageEntity ouvrage) {
        this.ouvrage = ouvrage;
    }
}
