package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Socket programlama icin kutuphaneler
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

@WebServlet(name = "sendMessageController", urlPatterns = {"/sendMessageController"})
public class sendMessageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        
        String message=request.getParameter("message");
        Socket serverSocket;
        DataOutputStream dataOutputStream;
        try {
//          Mesajin gonderilecegi ip adresi localhost kismina ve
//          1453 kismina ilgili cihazin Java uzerinden atanan 
//          port adresi yazilmalidir. Dinleyici kisminda
//          port numarasi atamasi yapilmis olmalidir.
            serverSocket = new Socket("localhost", 1453);
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF(message);
            serverSocket.close();
            response.sendRedirect("chatpanel.jsp");
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
    }

}
