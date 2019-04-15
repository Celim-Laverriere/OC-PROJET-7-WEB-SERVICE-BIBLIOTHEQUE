package org.service.model.bean;

import java.util.Date;

public class Emprunt {

    /* ====== Attributs ====== */
    private Integer id;
    private Date date_debut;
    private Date date_fin;
    private Boolean prolongation;

    /* ====== Constructeur ====== */
    public Emprunt() {
    }

    /* ====== Getter & Setter ====== */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Boolean getProlongation() {
        return prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        this.prolongation = prolongation;
    }
}
