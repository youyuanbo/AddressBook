/*
 * Created by JFormDesigner on Wed Jun 05 14:59:37 CST 2019
 */
/*
package com.addressbook.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.addressbook.bean.Person;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import com.addressbook.util.LoginFrame;
import com.addressbook.util.ViewUtil;
import net.miginfocom.swing.MigLayout;
*/
/**
 * @author xiaoyou
 */
/*
@SuppressWarnings("ALL")
public class RegisterFrame extends JFrame {

    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

    LoginFrame loginFrame = new LoginFrame();


    public RegisterFrame() {
        initComponents();
    }

    private void resetActionPerformed(ActionEvent e) {
        this.username.setText("");
        this.password.setText("");
    }

    private void cancelActionPerformed(ActionEvent e) {
        this.dispose();
        loginFrame.setVisible(true);
    }

    private void registerActionPerformed(ActionEvent e) {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xiaoyou
        label1 = new JLabel();
        label2 = new JLabel();
        username = new JTextField();
        label3 = new JLabel();
        password = new JPasswordField();
        register = new JButton();
        reset = new JButton();
        cancel = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[60,fill]" +
            "[109,fill]" +
            "[101,fill]" +
            "[98,fill]" +
            "[95,fill]" +
            "[60,fill]",
            // rows
            "[55]" +
            "[61]" +
            "[52]" +
            "[58]" +
            "[29]"));

        //---- label1 ----
        label1.setText(ViewUtil.REGISTER_TITLE);
        label1.setFont(new Font("Hack", Font.PLAIN, 22));
        contentPane.add(label1, "cell 0 0 5 1,align center center,grow 0 0");

        //---- label2 ----
        label2.setText(ViewUtil.REGISTER_USERNAME);
        label2.setFont(new Font("Hack", Font.PLAIN, 20));
        contentPane.add(label2, "cell 1 1,aligny center,growy 0");
        contentPane.add(username, "cell 2 1 3 1,aligny center,growy 0,width 300:300:300,height 40:40:40");

        //---- label3 ----
        label3.setText(ViewUtil.REGISTER_PASSWORD);
        label3.setFont(new Font("Hack", Font.PLAIN, 20));
        contentPane.add(label3, "cell 1 2,aligny center,growy 0");
        contentPane.add(password, "cell 2 2 3 1,width 300:300:300,height 40:40:40");

        //---- register ----
        register.setText(ViewUtil.REGISTER_BUTTON_REGISTER);
        register.setFont(new Font("Hack", Font.PLAIN, 16));
        register.addActionListener(e -> registerActionPerformed(e));
        contentPane.add(register, "cell 2 3,aligny center,growy 0");

        //---- reset ----
        reset.setText(ViewUtil.REGISTER_BUTTON_RESET);
        reset.setFont(new Font("Hack", Font.PLAIN, 16));
        reset.addActionListener(e -> resetActionPerformed(e));
        contentPane.add(reset, "cell 3 3,aligny center,growy 0");

        //---- cancel ----
        cancel.setText(ViewUtil.CANCEL);
        cancel.setFont(new Font("Hack", Font.PLAIN, 16));
        cancel.addActionListener(e -> cancelActionPerformed(e));
        contentPane.add(cancel, "cell 4 3,aligny center,growy 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xiaoyou
    private JLabel label1;
    private JLabel label2;
    private JTextField username;
    private JLabel label3;
    private JPasswordField password;
    private JButton register;
    private JButton reset;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
*/