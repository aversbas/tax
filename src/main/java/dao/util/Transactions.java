package dao.util;

/**
 * Created by alexm on 24.08.2019.
 */
public interface Transactions {

    public void begin() throws PersistException;


    public void commit() throws PersistException;


    public void rollback() throws PersistException;

}
