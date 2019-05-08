package org.bibliotheque.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo")
@Getter @Setter
@NoArgsConstructor
public class PhotoEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "url_photo")
    private String urlPhoto;
    @Column(name = "nom_photo")
    private String nomPhoto;

    @ManyToOne
    @JoinColumn(name = "ouvrage_id")
    private OuvrageEntity ouvragePhoto;

}
