package dao;

import java.util.List;
import modelo.Pessoa;

public interface IDAO {

    public boolean persist(int id_pessoa);

    public void delete(int id_pessoa);

    public void update(Pessoa p);

    public Object get(int id_pessoa);

    public List getAll();
}
