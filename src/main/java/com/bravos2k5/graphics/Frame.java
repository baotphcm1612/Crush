/*
 * Created by JFormDesigner on Tue Feb 13 01:46:11 ICT 2024
 */

package com.bravos2k5.graphics;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.bravos2k5.services.LoginService;
import net.miginfocom.swing.*;

/**
 * @author Quoc Bao SOFT DEV
 */
public class Frame extends JFrame {
    public Frame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Crush++");
        this.getContentPane().setBackground(new Color(30,30,30));
        this.setResizable(false);
        this.setVisible(true);
    }

    private void login(ActionEvent e) {
        String password = new String(passwordField1.getPassword());
        if(LoginService.Login(textField1.getText(),password)) {
            JOptionPane.showMessageDialog(null,"Login Successful");
        }
        else {
            JOptionPane.showMessageDialog(null, "Username or password was wrong");
        }
    }

    private void register(ActionEvent e) {
        final String password = new String(passwordField1.getPassword());
        LoginService.Register(textField1.getText(),password);

    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Nguyễn Quốc Bảo
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        loginButton = new JButton();
        registerButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) )
            ; panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Username:");
            panel1.add(label1, "cell 1 0");
            panel1.add(textField1, "cell 2 0 11 1");

            //---- label2 ----
            label2.setText("Password:");
            panel1.add(label2, "cell 1 1");
            panel1.add(passwordField1, "cell 2 1 11 1");

            //---- loginButton ----
            loginButton.setText("Login");
            loginButton.addActionListener(e -> login(e));
            panel1.add(loginButton, "cell 4 2");

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.addActionListener(e -> register(e));
            panel1.add(registerButton, "cell 8 2");
        }
        contentPane.add(panel1, "cell 2 1 16 7");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Nguyễn Quốc Bảo
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton registerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
