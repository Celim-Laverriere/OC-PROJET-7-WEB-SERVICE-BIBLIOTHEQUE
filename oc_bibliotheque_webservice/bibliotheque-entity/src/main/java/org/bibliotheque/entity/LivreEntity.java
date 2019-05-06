package org.bibliotheque.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "livre")
@Getter @Setter
@NoArgsConstructor
public class LivreEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "ref_bibliotheque")
    private String refBibliotheque;
    @Column(name = "ouvrage_id")
    private Integer ouvrageId;

}
