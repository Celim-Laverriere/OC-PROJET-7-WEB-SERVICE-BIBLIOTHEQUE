package org.service.model.bean;

public class Compte {

    /* ====== Attributs ====== */
    private Integer id;
    private String nom;
    private String prenom;
    private String addresse;
    private Integer code_postal;
    private String ville;
    private Integer num_portable;
    private Integer num_domicile;
    private Integer num_catre_bibliotheque;
    private String mail;
    private String mot_de_passe;

    /* ====== Constructeur ====== */
    public Compte() {
    }

    /* ====== Getter & Setter ====== */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public Integer getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(Integer code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getNum_portable() {
        return num_portable;
    }

    public void setNum_portable(Integer num_portable) {
        this.num_portable = num_portable;
    }

    public Integer getNum_domicile() {
        return num_domicile;
    }

    public void setNum_domicile(Integer num_domicile) {
        this.num_domicile = num_domicile;
    }

    public Integer getNum_catre_bibliotheque() {
        return num_catre_bibliotheque;
    }

    public void setNum_catre_bibliotheque(Integer num_catre_bibliotheque) {
        this.num_catre_bibliotheque = num_catre_bibliotheque;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
