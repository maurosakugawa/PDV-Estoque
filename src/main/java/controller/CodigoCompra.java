
import model.Produto;
import model.ProdutoDAOImpl;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

@WebServlet(name = "buscarCodigoCompra.action", urlPatterns = "/buscarCodigoCompra.action")
public class CodigoCompra extends HttpServlet  {   
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 

        ServletContext sc = req.getServletContext();
        ProdutoDAOImpl pd = new ProdutoDAOImpl();
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        
        try{
            Integer codigo = Integer.parseInt(req.getParameter("codigo"));
            Produto produto = pd.findByCodigo(codigo);
            System.out.print("produto e : " + produto);
            pw.println("<tr>");
                pw.println("<td> <input hidden name='codigoCarrinho"+produto.getCodigo()+"' value='"+produto.getCodigo()+"'></td>");
            pw.println("</tr>");
            pw.println("<tr>");
                pw.println("<td> " + produto.getCodigo() + "</td>");
                pw.println("<td>" + produto.getNome() + "</td>");
                pw.println("<td>" + produto.getUnidade() + "</td>");
                pw.println("<td>" + produto.getPreco() + "</td>");
                pw.println("<td><input type='number' placeholder='Quantidade' min='1' id='quantidade"+produto.getCodigo()+"'></td>");
            pw.println("</tr>");
            } catch(Exception e ){
        }
    }
}