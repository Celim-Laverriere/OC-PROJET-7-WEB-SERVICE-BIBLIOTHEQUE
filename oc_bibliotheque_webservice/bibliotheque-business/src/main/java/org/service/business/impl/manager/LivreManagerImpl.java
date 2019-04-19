package org.service.business.impl.manager;

import org.service.business.contract.manager.LivreManager;
import org.service.business.impl.AbstractManagerImpl;
import org.service.model.bean.Livre;

import java.util.List;

public class LivreManagerImpl extends AbstractManagerImpl implements LivreManager {

    public List<Livre> listLivre (){
        List<Livre> livreList = (List<Livre>) getDaoFactory().getLivreDao().findAll();
        return livreList;
    }
}
