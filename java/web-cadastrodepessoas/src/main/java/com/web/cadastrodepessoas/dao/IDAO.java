package com.web.cadastrodepessoas.dao;

import java.util.List;

public interface IDAO {

    public void delete(Object id_pessoa);

    public void update(Object p);

    public Object get(Object id_pessoa);

    public List getAll();
    
}