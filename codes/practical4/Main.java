import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            File file = new File("student.txt");
            FileWriter fw = new FileWriter(file, true); // true = append mode
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            fw.write("Roll No: " + roll + ", Name: " + name + ", Marks: " + marks + "\n");
            fw.close();
            System.out.println("\nData written to file successfully!");
            System.out.println("\n--- Student Records ---");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}