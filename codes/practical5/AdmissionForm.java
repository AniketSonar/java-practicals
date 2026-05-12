import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdmissionForm extends JFrame implements ActionListener {
    JTextField nameField, mobileField;
    JTextArea addressArea;
    JRadioButton male, female;
    JComboBox<String> courseBox;
    JButton submitBtn, resetBtn;

    AdmissionForm() {
        setTitle("Admission Enquiry Form");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);
        add(new JLabel("Mobile:"));
        mobileField = new JTextField(20);
        add(mobileField);
        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        add(male);
        add(female);
        add(new JLabel("Course:"));
        String courses[] = { "BCA", "MCA", "BSc IT", "MSc IT" };
        courseBox = new JComboBox<>(courses);
        add(courseBox);
        add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20);
        add(addressArea);
        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        add(submitBtn);
        add(resetBtn);
        submitBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            String name = nameField.getText();
            String mobile = mobileField.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String course = (String) courseBox.getSelectedItem();
            String address = addressArea.getText();
            JOptionPane.showMessageDialog(this,
                    "Name: " + name +
                            "\nMobile: " + mobile +
                            "\nGender: " + gender +
                            "\nCourse: " + course +
                            "\nAddress: " + address);
        }
        if (e.getSource() == resetBtn) {
            nameField.setText("");
            mobileField.setText("");
            addressArea.setText("");
            male.setSelected(false);
            female.setSelected(false);
            courseBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new AdmissionForm();
    }
}
