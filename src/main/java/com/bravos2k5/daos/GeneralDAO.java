package com.bravos2k5.daos;

import java.util.List;

public interface GeneralDAO<T> {
    public List<T> selectAll();

    public T selectById(T variable);

    public boolean insert(T variable);

    public boolean update(T variable);

    public boolean delete(T variable);

}
