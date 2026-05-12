import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String marks = request.getParameter("marks");
        out.println("<h2>GET Method Response</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Marks: " + marks);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String marks = request.getParameter("marks");
        out.println("<h2>POST Method Response</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Marks: " + marks);
    }
}