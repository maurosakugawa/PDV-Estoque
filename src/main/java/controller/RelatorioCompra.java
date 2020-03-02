import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import model.ProdutoDAOImpl;
import model.Produto;

@WebServlet( name = "relatorioCompra.action", urlPatterns = "/relatorioCompra.action")
public class RelatorioCompra extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        ServletContext sc = req.getServletContext();
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        ProdutoDAOImpl pd = new ProdutoDAOImpl();

        try{
            req.setCharacterEncoding("UTF-8"); 
        }catch(Exception e){} 


        try{
            String listaCodigo = req.getParameter("listaCodigo");
            System.out.println("Lista e :" + listaCodigo);
            listaCodigo = listaCodigo.replaceAll("\\[", "");
            listaCodigo = listaCodigo.replaceAll("\\]", "");
            listaCodigo = listaCodigo.replaceAll("\\,", " ");
            listaCodigo = listaCodigo.replaceAll("\"", "");

            String[] p = listaCodigo.split(" ");

            int[] prodComp = new int[p.length/2];
            int[] prodQuan = new int[p.length/2];

            int j = 0;
            int k = 0;
            for(int i = 0; i<p.length; i++){
                System.out.println("numeros: " + p[i]);
                if(i < (p.length / 2)){
                    prodComp[j] = Integer.parseInt(p[i]);
                    System.out.println("codigos: " + prodComp[j]);
                    j++;
                } else{
                    prodQuan[k] = Integer.parseInt(p[i]);
                    System.out.println("quantidades: " + prodQuan[k]);
                    k++;
                }
            }
            
            System.out.println("Deu certo aqui!");
            Double total = 0.0;
            int flag = 0;
            for(int i = 0; i < prodComp.length; i++){
                System.out.println("Deu certo " + prodQuan[i]);
                flag = flag + 1;
                System.out.println("Deu certo aqui 2 !");
                if(pd.comprar(prodComp[i], prodQuan[i])){
                    Produto produto = pd.findByCodigo(prodComp[i]);
                    total = total + (prodQuan[i] * produto.getPreco());
                    System.out.println("Deu certo aqui 3 !");
                    if(flag == 1){
                        pw.println("<tr>");
                            pw.println("<td> Relatorio Compra </td>");
                        pw.println("</tr>");
                        pw.println("<tr>");
                            pw.println("<th> Codigo </th>");
                            pw.println("<th> Nome </th>");
                            pw.println("<th> Unidade </th>");
                            pw.println("<th> Valor Total </th>");
                        pw.println("</tr>");
                        System.out.println("Deu certo aqui 4 !");
                    }
                    pw.println("<tr>");
                        pw.println("<td> " + produto.getCodigo() + "</td>");
                        pw.println("<td>" + produto.getNome() + "</td>");
                        pw.println("<td>" + produto.getUnidade() + "</td>");
                        pw.println("<td>" + prodQuan[i] * produto.getPreco() + "</td>");
                    pw.println("</tr>");
                    System.out.println("Deu certo aqui 5 !");
                    if(flag == prodComp.length){
                        pw.println("<tr>");
                            pw.println("<td> Total: " + total + "</td>");
                        pw.println("</tr>");
                        System.out.println("Deu certo aqui 6 !");
                    }
                }
            }
        } catch(Exception e){
             System.out.println("Erro ao comprar");
        }
    }
}
