package model;

import model.Produto;
import java.util.List;


public interface ProdutoDAO {
    public boolean insert(Produto produto);
    public boolean update(Produto produto);
    public boolean delete(Integer codigo);   
    public Produto findByCodigo(Integer codigo);
    public List<Produto> findAll();
    public boolean comprar(Integer codigo, Integer quantidade);
}