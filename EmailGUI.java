package Email_java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        
        Color pink = new Color(255, 192, 203);
        Color peach = new Color(255, 218, 185);

        GradientPaint gradient = new GradientPaint(
            0, 0, pink,
            0, getHeight(), peach
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

public class EmailGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Email Generator");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new GradientPanel());
        frame.setLayout(new GridLayout(8, 2, 10, 10));
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = {"engineering", "development", "accounting", "techsupport"};
        JComboBox<String> departmentBox = new JComboBox<>(departments);

        JLabel companyLabel = new JLabel("Company Name:");
        JTextField companyField = new JTextField();

        JLabel passwordLengthLabel = new JLabel("Password Length:");
        JTextField passwordLengthField = new JTextField();

        JLabel alternateEmailLabel = new JLabel("Alternate Email:");
        JTextField alternateEmailField = new JTextField();

        JButton submitButton = new JButton("Generate Email");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        frame.add(firstNameLabel);
        frame.add(firstNameField);

        frame.add(lastNameLabel);
        frame.add(lastNameField);

        frame.add(departmentLabel);
        frame.add(departmentBox);

        frame.add(companyLabel);
        frame.add(companyField);

        frame.add(passwordLengthLabel);
        frame.add(passwordLengthField);

        frame.add(alternateEmailLabel);
        frame.add(alternateEmailField);

        frame.add(submitButton);
        frame.add(new JLabel()); 
        frame.add(new JLabel("Result:"));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        frame.add(scrollPane);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstname = firstNameField.getText();
                    String lastname = lastNameField.getText();
                    String department = (String) departmentBox.getSelectedItem();
                    String company = companyField.getText();
                    int passwordLength = Integer.parseInt(passwordLengthField.getText());
                    String altEmail = alternateEmailField.getText();

                    EmailforGUI email = new EmailforGUI(firstname, lastname, department, passwordLength, company);
                    email.setAlternateEmail(altEmail);
                    email.setMailboxCapacity(500); 

                    resultArea.setText(email.displayInfo());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for password length.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
