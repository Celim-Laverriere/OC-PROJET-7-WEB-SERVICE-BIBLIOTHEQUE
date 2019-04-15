package org.service.model.bean;

public class Photo {

    /* ====== Attributs ====== */
    private Integer id;
    private String url_photo;
    private String nom_photo;

    /* ====== Constructeur ====== */
    public Photo() {
    }


    /* ====== Getter & Setter ====== */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public String getNom_photo() {
        return nom_photo;
    }

    public void setNom_photo(String nom_photo) {
        this.nom_photo = nom_photo;
    }
}
