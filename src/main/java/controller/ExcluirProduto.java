
import model.ProdutoDAOImpl;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "excluir.action", urlPatterns = "/excluir.action")
public class ExcluirProduto extends HttpServlet {   
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 

        ServletContext sc = req.getServletContext();
        ProdutoDAOImpl pd = new ProdutoDAOImpl();
        
        try{
            Integer codigo = Integer.parseInt(req.getParameter("id"));
            boolean produtoExcluido = pd.delete(codigo);
            if(produtoExcluido){
                req.setAttribute("mensagem", "Sucesso ao excluir o produto!");
            }
        } catch(Exception e ){
            System.out.print("erro " + e);
            req.setAttribute("mensagem", "Erro ao excluir o produto. Confira se o mesmo já não foi excluído.");
        }


        try {
            sc.getRequestDispatcher("/jsp/estoque.jsp").forward(req, resp); 
        }catch(Exception e){
            //Tratamento de erro de IO ou de Servlet..
        }
    }
}