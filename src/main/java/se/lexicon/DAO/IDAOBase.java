package se.lexicon.DAO;

import java.util.Collection;

public interface IDAOBase<T, ID> {

    /**
     persist
     */
    public T create(T item);

    public Collection<T> findAll();

    public T find(ID item);

    public void remove(ID item);
}
