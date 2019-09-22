package dao;

import java.io.Serializable;

/**
 * Created by alexm on 12.08.2019.
 */
public interface Identified <PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    public Long getId();
}