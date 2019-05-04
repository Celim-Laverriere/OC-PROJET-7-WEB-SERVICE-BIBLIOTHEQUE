package org.bibliotheque.entity;
import java.util.Collection;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "emprunt")
@Getter @Setter
public class EmpruntEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;
    private Boolean prolongation;
//    @Column(name = "livre_id")
//    private Integer livreId;
//    @Column(name = "compte_id")
//    private Integer compteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id")
    private LivreEntity livre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compte_id")
    private CompteEntity compte;

    public EmpruntEntity() {
    }

    public EmpruntEntity(Date dateDebut, Date dateFin, Boolean prolongation, LivreEntity livre, CompteEntity compte) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prolongation = prolongation;
        this.livre = livre;
        this.compte = compte;
    }
}
