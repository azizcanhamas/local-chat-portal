package Controller;

//Socket programlama icin kutuphaneler
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "takeMessageController", urlPatterns = {"/takeMessageController"})
public class takeMessageController extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        new Thread(new Runnable(){
            @Override
            public void run(){
                ServerSocket serverSocket;
                Socket clientSocket;
                DataInputStream dataInputStream;
                String message;
                try {
        //            Port numarasi atamasi
                    serverSocket = new ServerSocket(1453);
                    clientSocket = serverSocket.accept();
                    dataInputStream = new DataInputStream(clientSocket.getInputStream());
                    message = dataInputStream.readUTF();
//                    PrintWriter out = response.getWriter();
//                    out.println(message);
                    serverSocket.close();
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
        
               
    }

}
