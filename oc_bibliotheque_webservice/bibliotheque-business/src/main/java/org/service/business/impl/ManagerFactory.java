package org.service.business.impl;

import org.service.business.contract.manager.*;

public class ManagerFactory implements org.service.business.contract.ManagerFactory {

    private CompteManager compteManager;
    private EmpruntManager empruntManager;
    private LivreManager livreManager;
    private OuvrageManager ouvrageManager;
    private PhotoManager photoManager;

    @Override
    public CompteManager getCompteManager() {
        return compteManager;
    }

    @Override
    public void setCompteManager(CompteManager compteManager) {
        this.compteManager = compteManager;
    }

    @Override
    public EmpruntManager getEmpruntManager() {
        return empruntManager;
    }

    @Override
    public void setEmpruntManager(EmpruntManager empruntManager) {
        this.empruntManager = empruntManager;
    }

    @Override
    public LivreManager getLivreManager() {
        return livreManager;
    }

    @Override
    public void setLivreManager(LivreManager livreManager) {
        this.livreManager = livreManager;
    }

    @Override
    public OuvrageManager getOuvrageManager() {
        return ouvrageManager;
    }

    @Override
    public void setOuvrageManager(OuvrageManager ouvrageManager) {
        this.ouvrageManager = ouvrageManager;
    }

    @Override
    public PhotoManager getPhotoManager() {
        return photoManager;
    }

    @Override
    public void setPhotoManager(PhotoManager photoManager) {
        this.photoManager = photoManager;
    }
}
