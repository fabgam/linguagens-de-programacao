package br.com.java.terminal.cad.dao;

import java.util.List;

public interface IDAO {

    public boolean persist(Object p);

    public void delete(Object id_pessoa);

    public void update(Object p);

    public Object get(Object id_pessoa);

    public List<?> getAll();
}
