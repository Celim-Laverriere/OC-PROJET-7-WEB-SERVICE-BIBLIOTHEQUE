package org.service.model.bean;

public class Livre {

    /* ====== Attributs ====== */
    private Integer id;
    private String ref_bibliotheque;

    /* ====== Constructeur ====== */
    public Livre() {
    }

    /* ====== Getter & Setter ====== */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRef_bibliotheque() {
        return ref_bibliotheque;
    }

    public void setRef_bibliotheque(String ref_bibliotheque) {
        this.ref_bibliotheque = ref_bibliotheque;
    }
}
