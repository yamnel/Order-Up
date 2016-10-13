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
    JLabel username;
    JLabel password;


    public LogInScreen(){
        super("Login Screen");

        btnLogIn = new JButton("Login");
        btnCancel = new JButton("Cancel");  // we probably don't need a new usr
        logInPanel = new JPanel();
        txtUser = new JTextField(15);
        txtPassword = new JPasswordField(15);



        username = new JLabel("Email ");
        password = new JLabel("Password ");

        setSize(300,200);
        setLocation(500,280);
        logInPanel.setLayout (null);


        txtUser.setBounds(90,30,150,20);
        txtPassword.setBounds(90,65,150,20);
        btnLogIn.setBounds(110,100,80,20);
        btnCancel.setBounds(110,135,80,20);
        username.setBounds(20,28,80,20);
        password.setBounds(20,63,80,20);

        logInPanel.add(btnLogIn);
        logInPanel.add(txtUser);
        logInPanel.add(txtPassword);
        logInPanel.add(btnCancel);
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
