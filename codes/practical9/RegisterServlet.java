import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb",
                    "root",
                    "root");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO users(name,email,password) VALUES(?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h3>Registration Successful!</h3>");
            } else {
                out.println("<h3>Registration Failed!</h3>");
            }
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}