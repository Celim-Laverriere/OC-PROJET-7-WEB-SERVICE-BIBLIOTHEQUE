package org.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "ouvrage")
@Getter @Setter
public class OuvrageEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String genre;
    private String resumer;
    private String auteur;
    private String editeur;
    private String ref;
    @Column(name = "photo_id")
    private Integer photoId;

    @OneToMany(mappedBy = "ouvrage")
    private Collection<PhotoEntity> photos;

    @OneToMany(mappedBy = "ouvrage")
    private Collection<LivreEntity> livres;

    public OuvrageEntity() {
    }

    public OuvrageEntity(String titre, String genre, String resumer, String auteur, String editeur, String ref) {
        this.titre = titre;
        this.genre = genre;
        this.resumer = resumer;
        this.auteur = auteur;
        this.editeur = editeur;
        this.ref = ref;
    }
}
