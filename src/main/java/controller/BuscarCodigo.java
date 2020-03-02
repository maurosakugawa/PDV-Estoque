
import model.Produto;
import model.ProdutoDAOImpl;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "buscarCodigo.action", urlPatterns = "/buscarCodigo.action")
public class BuscarCodigo extends HttpServlet {   

    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 

        ServletContext sc = req.getServletContext();
        ProdutoDAOImpl pd = new ProdutoDAOImpl();
        
        try{
            Integer codigo = Integer.parseInt(req.getParameter("buscaCodigo"));
            Produto produto = pd.findByCodigo(codigo);
            req.setAttribute("Produto", produto);
            System.out.print("Produto .....  " + produto);
            System.out.print("Produto e " + produto.getNome());
            req.setAttribute("codigoProdutoExcluir", produto.getCodigo());
            req.setAttribute("mensagem", "Sucesso ao encontrar o produto!");
        } catch(Exception e ){
            req.setAttribute("mensagem", "Digite um numero inteiro para o codigo.");
        }


        try {
            sc.getRequestDispatcher("/jsp/estoque.jsp").forward(req, resp); 
        }catch(Exception e){
            //Tratamento de erro de IO ou de Servlet..
        }
    }
}