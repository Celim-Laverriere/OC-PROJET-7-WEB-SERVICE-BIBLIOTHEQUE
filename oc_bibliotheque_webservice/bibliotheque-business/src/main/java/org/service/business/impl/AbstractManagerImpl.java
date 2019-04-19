package org.service.business.impl;

import org.service.consumer.contract.DaoFactory;


public abstract class AbstractManagerImpl {

    private DaoFactory daoFactory;

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
