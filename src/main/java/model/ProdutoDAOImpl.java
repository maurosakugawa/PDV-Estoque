package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Produto;
import model.ProdutoDAO;

@SuppressWarnings("unchecked")
public class ProdutoDAOImpl implements ProdutoDAO {

    protected EntityManager entityManager;

    @Override
    public boolean insert(Produto produto){
        entityManager = ServicoEntityManager.getEntityManager();
        if(findByCodigo(produto.getCodigo()) != null){
            return false;
        } else{
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();


            entityManager.close();
            return true;
        }
    }

    @Override
    public boolean update(Produto produto){
        entityManager = ServicoEntityManager.getEntityManager();
        try{
            Query query = entityManager.createQuery("select p from Produto p  where p.codigo = :codigo", Produto.class); 
            query.setParameter("codigo", produto.getCodigo());  
            Produto produtoResult = (Produto)query.getSingleResult();

            entityManager.getTransaction().begin();
            produtoResult.setNome(produto.getNome());
            produtoResult.setUnidade(produto.getUnidade());
            produtoResult.setPreco(produto.getPreco());
            produtoResult.setQuantidade(produto.getQuantidade());
            produtoResult.setDescricao(produto.getDescricao());
            entityManager.getTransaction().commit();

            entityManager.close();

            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Integer codigo){
        entityManager = ServicoEntityManager.getEntityManager();
        try{
            Query query = entityManager.createQuery("select p from Produto p  where p.codigo = :codigo", Produto.class);
            query.setParameter("codigo", codigo);
            Produto produto = (Produto)query.getSingleResult();

            entityManager.getTransaction().begin();
            entityManager.remove(produto);
            entityManager.getTransaction().commit();

            entityManager.close();

            return true;
        } catch(Exception e ){
            return false;
        }
    }

    @Override
    public Produto findByCodigo(Integer codigo){
        entityManager = ServicoEntityManager.getEntityManager();
        try{
            Query query = entityManager.createQuery("select p from Produto p  where p.codigo = :codigo", Produto.class); 

            query.setParameter("codigo", codigo);  

            Produto produto = (Produto)query.getSingleResult();

            entityManager.close();


            return produto;
        } catch(Exception e){
            return null;
        }
    }

    @Override
    public List<Produto> findAll(){
        entityManager = ServicoEntityManager.getEntityManager();
        Query query = entityManager.createQuery("select p from Produto p ", Produto.class); 
        List<Produto> produto = query.getResultList();

        entityManager.close();

        return produto;
    }

    @Override
    public boolean comprar(Integer codigo, Integer quantidade){
        Produto p = findByCodigo(codigo);
        if(p != null){
            if(p.getQuantidade() >= quantidade){
                entityManager = ServicoEntityManager.getEntityManager();

                if(p.getQuantidade() - quantidade >= 0){
                    Query query = entityManager.createQuery("select p from Produto p  where p.codigo = :codigo", Produto.class); 
                    query.setParameter("codigo", codigo);  
                    Produto produtoResult = (Produto)query.getSingleResult();

                    entityManager.getTransaction().begin();
                    produtoResult.setQuantidade(p.getQuantidade() - quantidade);
                    entityManager.getTransaction().commit();

                    entityManager.close();

                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}