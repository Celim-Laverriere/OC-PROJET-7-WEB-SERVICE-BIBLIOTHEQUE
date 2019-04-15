package org.service.consumer.contract;

import org.service.consumer.contract.dao.*;

public interface DaoFactory {

    CompteDao getCompteDao();

    void setCompteDao(CompteDao compteDao);

    EmpruntDao getEmpruntDao();

    void setEmpruntDao(EmpruntDao empruntDao);

    LivreDao getLivreDao();

    void setLivreDao(LivreDao livreDao);

    OuvrageDao getOuvrageDao();

    void setOuvrageDao(OuvrageDao ouvrageDao);

    PhotoDao getPhotoDao();

    void setPhotoDao(PhotoDao photoDao);
}
