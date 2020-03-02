import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns={"/cadastrar"})
public class Cadastrar extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        
        ServletContext sc = req.getServletContext();

        req.setAttribute("Atualizar", 0);
        
        try{
            sc.getRequestDispatcher("/jsp/cadastrar.jsp").forward(req, resp);            
            } catch (Exception e){}
    }
}

