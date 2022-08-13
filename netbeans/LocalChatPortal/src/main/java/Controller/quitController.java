
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Session kutuphanesi
import javax.servlet.http.HttpSession;

@WebServlet(name = "quitController", urlPatterns = {"/quitController"})
public class quitController extends HttpServlet {

//  HTTP metodu olmadigi icin icin service metodu override edildi!
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
//        Oturumu sonlandir ve ana sayfaya yonlendir.
            HttpSession session=request.getSession(); 
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
    }