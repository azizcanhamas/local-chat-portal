package Controller;

//Bu dosya Servlet dosyasidir ve bir paket altindadir. Kendine özgü metotlari vardir.


//Model katmanina erisebilmek icin
import Model.userModel;

//ResultSet'i kullanabilmek icin
import java.sql.ResultSet;
import java.sql.SQLException;

//Session için
import javax.servlet.http.HttpSession;

//Servlet ile alakali kutuphaneler
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {

//    HTML ciktisi bastirmak icin
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
                    HttpSession session=request.getSession();                  
                    session.setAttribute("email", email);
                    response.sendRedirect("chatpanel.jsp");
                    
                    //Başka bir yonlendirme yontemi
                    //RequestDispatcher req = request.getRequestDispatcher("chatpanel.jsp");
                    //req.forward(request, response); /*veya*/ req.include(request, response);
                }
                else{                       
                    response.sendRedirect("index.jsp");
                }
                
            }catch(SQLException e){
//                Hatayi tarayiciya yazdiracak.
               response.getWriter().print(e);
               processRequest(request, response);
            }
            
    }
    
}
