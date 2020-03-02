
import model.Produto;
import model.ProdutoDAO;
import model.ProdutoDAOImpl;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cadastro.action", urlPatterns = "/cadastro.action")
public class Cadastro extends HttpServlet {   

    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp){

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 

        ServletContext sc = req.getServletContext();
        System.out.println("eooooo");
        ProdutoDAOImpl pd = new ProdutoDAOImpl();
        req.setAttribute("Atualizar", 0);
        
        Produto p = verificarCampos(req);
        if(p != null){
            System.out.println("produto nao e nulo");
             if(!pd.insert(p)){
                req.setAttribute("mensagem", "Erro ao inser o produto.");
            } 
        }

        try {
            sc.getRequestDispatcher("/jsp/cadastrar.jsp").forward(req, resp); 
        }catch(Exception e){
            //Tratamento de erro de IO ou de Servlet..
        }
    }

    public Produto verificarCampos(HttpServletRequest req){
        Produto p = new Produto();

        //codigo
        try{
            p.setCodigo(Integer.parseInt(req.getParameter("codigo")));
        }catch(Exception e){
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

        return p;
    }
}