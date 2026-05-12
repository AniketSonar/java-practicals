
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class DatabaseGUI extends JFrame implements ActionListener {
    JTextField queryField;
    JTextArea resultArea;
    JButton executeBtn;
    Connection con;

    DatabaseGUI() {
        this.setTitle("Database Query Executor");
        this.setSize(500, 400);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(3);
        this.add(new JLabel("Enter SQL Query:"));
        this.queryField = new JTextField(30);
        this.add(this.queryField);
        this.executeBtn = new JButton("Execute");
        this.add(this.executeBtn);
        this.resultArea = new JTextArea(15, 40);
        this.add(new JScrollPane(this.resultArea));
        this.executeBtn.addActionListener(this);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
            this.resultArea.setText("Connected to database!\n");
        } catch (Exception var2) {
            this.resultArea.setText("Connection Error: " + var2.getMessage());
        }

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent var1) {
        String var2 = this.queryField.getText();

        try {
            Statement var3 = this.con.createStatement();
            if (var2.toLowerCase().startsWith("select")) {
                ResultSet var4 = var3.executeQuery(var2);
                this.resultArea.setText("");
                ResultSetMetaData var5 = var4.getMetaData();
                int var6 = var5.getColumnCount();

                while (var4.next()) {
                    for (int var7 = 1; var7 <= var6; ++var7) {
                        JTextArea var10000 = this.resultArea;
                        String var10001 = var4.getString(var7);
                        var10000.append(var10001 + " ");
                    }

                    this.resultArea.append("\n");
                }
            } else {
                int var9 = var3.executeUpdate(var2);
                this.resultArea.setText(var9 + " row(s) affected.");
            }
        } catch (Exception var8) {
            this.resultArea.setText("Error: " + var8.getMessage());
        }

    }

    public static void main(String[] var0) {
        new DatabaseGUI();
    }
}
