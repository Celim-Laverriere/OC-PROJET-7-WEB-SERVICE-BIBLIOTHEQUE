package org.service.business.contract;

import org.service.business.contract.manager.*;

public interface ManagerFactory {

    CompteManager getCompteManager();

    void setCompteManager(CompteManager compteManager);

    EmpruntManager getEmpruntManager();

    void setEmpruntManager(EmpruntManager empruntManager);

    LivreManager getLivreManager();

    void setLivreManager(LivreManager livreManager);

    OuvrageManager getOuvrageManager();

    void setOuvrageManager(OuvrageManager ouvrageManager);

    PhotoManager getPhotoManager();

    void setPhotoManager(PhotoManager photoManager);
}
