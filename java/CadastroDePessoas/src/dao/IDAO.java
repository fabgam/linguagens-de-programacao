package dao;

import java.util.List;
import modelo.Pessoa;

public interface IDAO {

    public void persist(Pessoa p);

    public void delete(int id_pessoa);

    public void update(Pessoa p);

    public Object get(int id_pessoa);

    public List getAll();
}
