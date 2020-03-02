import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.ProdutoDAOImpl;

@WebServlet(name = "atualizarProduto.action", urlPatterns={"/atualizarProduto.action"})
public class AtualizarProduto extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();
        ProdutoDAOImpl pd = new ProdutoDAOImpl();

        Produto p = verificarCampos(req);
        System.out.println("atualizandooooo");
        if(p != null){
            System.out.println("atualizandooooooooooo 2");
            if(!pd.update(p)){
                req.setAttribute("mensagem", "Erro ao atualizar o produto.");
            } else{
                System.out.println("produto atualizado!!!");
                req.setAttribute("Produto", p);
                req.setAttribute("Atualizar", 1);
            }
        }else{
            req.setAttribute("Atualizar", 0);
        }
        try{
            sc.getRequestDispatcher("/jsp/cadastrar.jsp").forward(req, resp);            
        } catch (Exception e){}
    }

    public Produto verificarCampos(HttpServletRequest req){
        Produto p = new Produto();

        //codigo
        try{
            p.setCodigo(Integer.parseInt(req.getParameter("codigo")));
        }catch(Exception e){
            System.out.println("codigo e  !!!!!!!!!!");
            req.setAttribute("mensagem", "Erro. Insira um número inteiro para o Código.");
            return p = null;
        }  

        //nome
        p.setNome(req.getParameter("nome"));
        if(p.getNome().equals("")){
            req.setAttribute("mensagem", "Erro. Campo vazio para Nome.");
            return p = null;
        }

        //unidade
        p.setUnidade(req.getParameter("unidade"));
        if(p.getUnidade().equals("")){
            req.setAttribute("mensagem", "Erro. Campo vazio para Unidade.");
            return p = null;
        }

        //preco
        try{
            p.setPreco(Double.parseDouble(req.getParameter("preco")));
        } catch(Exception e){
            req.setAttribute("mensagem", "Erro. Insira um número para o Preço.");
            return p = null;

        }  

        //quantidade
        try{
            p.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
        } catch(Exception e){
            req.setAttribute("mensagem", "Erro. Insira um número inteiro para a Quantidade.");
            return p = null;

        }  

        //descricao
        p.setDescricao(req.getParameter("descricao"));
        if(p.getDescricao().equals("")){
            req.setAttribute("mensagem", "Erro. Campo vazio para Descrição.");
            return p = null;
        }

        req.setAttribute("mensagem", "Sucesso ao cadastrar Produto");
        System.out.println("produto nao deu erro ao converter");
        return p;
    }
}