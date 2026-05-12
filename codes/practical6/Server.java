import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server is waiting for client...");
            Socket s = ss.accept();
            System.out.println("Client connected!");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("Client says: " + msg);
                pw.println("Echo: " + msg);
                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}