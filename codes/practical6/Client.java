import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            String msg;
            while (true) {
                System.out.print("Enter message: ");
                msg = sc.nextLine();
                pw.println(msg);
                String response = br.readLine();
                System.out.println("Server: " + response);
                if (msg.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}