/**********************************\
 * Created by Yamnel on 10/13/16.
 * Edited with Zivko
 \**********************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LogInScreen extends JFrame {
    JButton btnLogIn;
    JPanel logInPanel;
    JTextField txtUser;
    JTextField txtPassword;
    JButton btnCancel;
    JLabel logoHolderLabel;
    JLabel schoolChoiceLabel;
    JLabel username;
    JLabel password;
    ImageIcon orderUpLogo;
    JComboBox schoolChoiceBox;

    //for schoolChoiceBox
    private static final String[] schoolNames = {" ","Florida Gulf Coast " +
            "University"};

    public LogInScreen(){
        super("Login Screen");

        schoolChoiceBox = new JComboBox(schoolNames); //puts schools into
        // comboBox rows
        orderUpLogo = new ImageIcon("OrderUpLogo 50x50.png");// holds the logo
        btnLogIn = new JButton("Login"); // login btn
        btnCancel = new JButton("Cancel");
        logInPanel = new JPanel();
        txtUser = new JTextField(15);
        txtPassword = new JPasswordField(15);

        schoolChoiceLabel = new JLabel("University ");
        username = new JLabel("Email ");
        password = new JLabel("Password ");

        //Our setLocation be different on other screen resolutions

        setSize(500,400); //sets the size of the frame
        setLocation(500,280); //sets the location of the frame on the screen
        logInPanel.setLayout (null);
        schoolChoiceBox.setMaximumRowCount(schoolNames.length); //sets max
        // rows to number of schools in schoolNames array

        //ctrl and hover over a function for info (intellij)
        //sets all of the specified location of each of the JObjects
        //if setSize is changed, these will be affected

        txtUser.setBounds(175,230,150,20); //TextFields
        txtPassword.setBounds(175,265,150,20); //TextFields
        btnLogIn.setBounds(210,300,80,20); //Buttons
        btnCancel.setBounds(210,335,80,20); //Buttons
        schoolChoiceBox.setBounds(175,150,150,20);
        schoolChoiceLabel.setBounds(112,150,80,20);
        username.setBounds(135,228,80,20); //JLabel
        password.setBounds(110,263,80,20); //JLabel


        //logInPanel.add(logoHolderLabel, BorderLayout.NORTH); wasn't working
        logInPanel.add(btnLogIn);
        logInPanel.add(txtUser);
        logInPanel.add(txtPassword);
        logInPanel.add(btnCancel);
        logInPanel.add(schoolChoiceBox);
        logInPanel.add(schoolChoiceLabel);
//        logInPanel.add(logoHolderLabel);
        logInPanel.add(username);
        logInPanel.add(password);

        getContentPane().add(logInPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Writer writer = null;
        File check = new File("userPass.txt");
        if(check.exists()){

            //Checks if the file exists. will not add anything if the file does exist.
        }else{
            try{
                File texting = new File("userPass.txt");
                writer = new BufferedWriter(new FileWriter(texting));
                writer.write("message");
            }catch(IOException e){
                e.printStackTrace();
            }
        }




        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("userPass.txt");
                    Scanner scan = new Scanner(file);;
                    String line = null;
                    FileWriter filewrite = new FileWriter(file, true);

                    String usertxt = " ";
                    String passtxt = " ";
                    String puname = txtUser.getText();
                    String ppaswd = txtPassword.getText();


                    while (scan.hasNext()) {
                        usertxt = scan.nextLine();
                        passtxt = scan.nextLine();

                    }




                    if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
                        //MainMenu menu =new MainMenu(); // We don't have a main menu yet
                        dispose();
                    }
                    else if(puname.equals("") && ppaswd.equals("")){
                        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
                    }
                    else {

                        JOptionPane.showMessageDialog(null,"Wrong Username / Password");
                        txtUser.setText("");
                        txtPassword.setText("");
                        txtUser.requestFocus();
                    }
                } catch (IOException d) {
                    d.printStackTrace();
                }

            }
        });



        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
