

import model.Produto;
import model.ProdutoDAO;
import model.ProdutoDAOImpl;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "relatorioestoque.action", urlPatterns = {"/relatorioestoque.action"})
public class GerarRelatorioEstoque extends HttpServlet {   
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 

        ServletContext sc = req.getServletContext();
        List<Produto> items = new ArrayList<>();

         try{
             ProdutoDAOImpl pd = new ProdutoDAOImpl();
             items = pd.findAll();
            
             req.setAttribute("ListaProdutos", items);
             req.setAttribute("gerarRelatorio", "Relatorio");
             req.setAttribute("quantidadeEstoque", items.size());
         } catch(Exception e){
             req.setAttribute("mensagem", "Erro ao gerar relatório do estoque.");
         }

        try {
            sc.getRequestDispatcher("/jsp/relatorioEstoque.jsp").forward(req, resp); 
        }catch(Exception e){
            //Tratamento de erro de IO ou de Servlet..
            System.out.println(e);
        }        
    }
}
