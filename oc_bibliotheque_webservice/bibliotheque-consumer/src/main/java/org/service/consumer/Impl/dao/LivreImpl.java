package org.service.consumer.Impl.dao;

import org.service.consumer.Impl.data.AbstractDataImpl;
import org.service.consumer.contract.dao.LivreDao;
import org.service.model.bean.Livre;
import java.util.List;


public class LivreImpl extends AbstractDataImpl implements LivreDao {


    @Override
    public <S extends Livre> S save(S s) {

        return null;
    }

    @Override
    public <S extends Livre> Iterable<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Livre findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Livre> findAll() {
        List<Livre> livreList = (List<Livre>) findAll();
        return livreList;
    }

    @Override
    public Iterable<Livre> findAll(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(Livre livre) {

    }

    @Override
    public void delete(Iterable<? extends Livre> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
