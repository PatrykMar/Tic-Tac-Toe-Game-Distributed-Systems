/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoejavaapp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ttt.james.server.TTTWebService;
import ttt.james.server.TTTWebService_Service;


/**
 *
 * @author Patryk
 */
public class TicTacToeJavaApp extends JFrame implements ActionListener {
    
    private TTTWebService_Service service;
    private TTTWebService proxy;
    
    JPanel loginPanel = null;
    JPanel registerPanel = null;
    JPanel gamePanel = null;
    
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    private int ID;
    private int GAME_ID;
    
    public TicTacToeJavaApp()
    {
        service = new TTTWebService_Service();
        proxy = service.getTTTWebServicePort();
        
        setTitle("Tic-Tac-Toe");
        loginPanel = showLogin();
        this.add(loginPanel);
        this.setVisible(true);
        this.pack();
  
    }
    
    public static void main (String [] args)
    {
       TicTacToeJavaApp app = new TicTacToeJavaApp();
    }
    public JPanel showLogin(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        
        JPanel user = new JPanel();
        JLabel userLabel = new JLabel("Username: ",JLabel.CENTER);
        usernameField = new JTextField("",10);
        
        user.add(userLabel);
        user.add(usernameField);
        user.setVisible(true);
        
        JPanel password = new JPanel();
        JLabel passwordLabel = new JLabel("Password: ",JLabel.CENTER);
        passwordField = new JPasswordField("",10);
        
        password.add(passwordLabel);
        password.add(passwordField);
        password.setVisible(true);
        
        JPanel control = new JPanel();
        JButton btn1 = new JButton("Login");
        btn1.setActionCommand("login");
        btn1.addActionListener(this);
        control.add(btn1);
        
        JButton btn2 = new JButton("Register");
        btn2.setActionCommand("register");
        btn2.addActionListener(this);
        control.add(btn2);
        
        mainPanel.add(user);
        mainPanel.add(password);
        mainPanel.add(control);
        mainPanel.setVisible(true);
        return mainPanel;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnPressed = e.getActionCommand();
        if(btnPressed.equalsIgnoreCase("login"))
        {
            ID = proxy.login(usernameField.getText(),new String (passwordField.getPassword()));
            if(ID > 0)
            {
                this.remove(loginPanel);
            }
        }
        else if(btnPressed.equalsIgnoreCase("register"))
        {
            
        }
    }
    
    
}
