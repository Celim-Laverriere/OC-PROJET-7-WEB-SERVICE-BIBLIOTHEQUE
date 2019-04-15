package org.service.consumer.Impl;

import org.service.consumer.contract.DaoFactory;
import org.service.consumer.contract.dao.*;

public class DaoFactoryImpl implements DaoFactory {

    private CompteDao compteDao;
    private EmpruntDao empruntDao;
    private LivreDao livreDao;
    private OuvrageDao ouvrageDao;
    private PhotoDao photoDao;

    @Override
    public CompteDao getCompteDao() {
        return compteDao;
    }

    @Override
    public void setCompteDao(CompteDao compteDao) {
        this.compteDao = compteDao;
    }

    @Override
    public EmpruntDao getEmpruntDao() {
        return empruntDao;
    }

    @Override
    public void setEmpruntDao(EmpruntDao empruntDao) {
        this.empruntDao = empruntDao;
    }

    @Override
    public LivreDao getLivreDao() {
        return livreDao;
    }

    @Override
    public void setLivreDao(LivreDao livreDao) {
        this.livreDao = livreDao;
    }

    @Override
    public OuvrageDao getOuvrageDao() {
        return ouvrageDao;
    }

    @Override
    public void setOuvrageDao(OuvrageDao ouvrageDao) {
        this.ouvrageDao = ouvrageDao;
    }

    @Override
    public PhotoDao getPhotoDao() {
        return photoDao;
    }

    @Override
    public void setPhotoDao(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }
}
