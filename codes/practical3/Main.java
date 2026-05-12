import java.util.Scanner;

class MarksOutOfBoundException extends Exception {
    MarksOutOfBoundException(String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            if (marks > 100) {
                throw new MarksOutOfBoundException("Marks out of Bound!");
            }
            System.out.println("Roll No: " + rollNo);
            System.out.println("Marks: " + marks);
        } catch (MarksOutOfBoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        sc.close();
    }
}