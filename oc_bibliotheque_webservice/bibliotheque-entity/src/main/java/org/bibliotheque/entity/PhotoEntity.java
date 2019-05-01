package org.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo")
@Getter @Setter
public class PhotoEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "nom_photo")
    private String nomPhoto;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "photo_id")
    private OuvrageEntity ouvrage;

    public PhotoEntity() {
    }

    public PhotoEntity(String urlPhoto, String nomPhoto, OuvrageEntity ouvrage) {
        this.urlPhoto = urlPhoto;
        this.nomPhoto = nomPhoto;
        this.ouvrage = ouvrage;
    }
}
