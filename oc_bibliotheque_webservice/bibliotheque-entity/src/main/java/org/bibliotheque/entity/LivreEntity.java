package org.bibliotheque.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "livre")
public class LivreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private Integer id;
    @Column(name = "ref_bibliotheque")
    private String refBibliotheque;
    @Column(name = "ouvrage_id")
    private Integer ouvrageId;

    public LivreEntity() {
    }

    public LivreEntity(String refBibliotheque, Integer ouvrageId) {
        this.refBibliotheque = refBibliotheque;
        this.ouvrageId = ouvrageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefBibliotheque() {
        return refBibliotheque;
    }

    public void setRefBibliotheque(String refBibliotheque) {
        this.refBibliotheque = refBibliotheque;
    }

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }
}
