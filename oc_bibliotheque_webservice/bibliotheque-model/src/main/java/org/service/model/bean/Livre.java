package org.service.model.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "livre")
public class Livre implements Serializable {

    /* ====== Attributs ====== */
    @Id @GeneratedValue
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
