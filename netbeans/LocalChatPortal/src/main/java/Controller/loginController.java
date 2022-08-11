package Controller;

//Bu dosya Servlet dosyasidir ve bir paket altindadir. Kendine özgü metotlari vardir.

import Model.userModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
        }
    }
    
    // POST yöntemi ile gelindiyse burasi calisir. GET yontemi icin ayri metot tanimlanmalidir.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)        
            throws ServletException, IOException {
            
            userModel m=new userModel();
        
            String email=request.getParameter("email");
            String password=request.getParameter("password");
        
            ResultSet rs=m.isUser(email, password);
            
            try{
                if(rs.next()) {
                    RequestDispatcher req = request.getRequestDispatcher("chatpanel.jsp");
                    // req.forward'da kullanilabilir.
                    req.include(request, response);
                }
                else{                       
                    RequestDispatcher req = request.getRequestDispatcher("index.jsp");
                    req.include(request, response);
                }
                
            }catch(SQLException e){
               response.getWriter().print(e);
               processRequest(request, response);
            }
            
    }
    
}
