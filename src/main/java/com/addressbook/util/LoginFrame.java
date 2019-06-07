/*
 * Created by JFormDesigner on Wed Jun 05 14:45:59 CST 2019
 */
/*
package com.addressbook.util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.addressbook.bean.Person;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.view.MainView;
import net.miginfocom.swing.*;
*/
/**
 * @author xiaoyou
 */

/*
@SuppressWarnings("ALL")
public class LoginFrame extends JFrame {

    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

    public LoginFrame() {
        initComponents();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    private void resetActionPerformed(ActionEvent e) {
        this.Personname.setText("");
        this.password.setText("");
    }

    private void registerActionPerformed(ActionEvent e) {
        RegisterFrame registerFrame = new RegisterFrame();
        this.dispose();
        registerFrame.setVisible(true);
    }

    private void loginActionPerformed(ActionEvent e) {
        String Personname = this.Personname.getText().trim();
        String password = String.valueOf(this.password.getPassword()).trim();


        if (!CheckUtil.checkUsername(Personname)){
            JOptionPane.showMessageDialog(this, "用户名不符合要求，用户名由5-10位英文字组成");
            this.Personname.requestFocus();
            return;
        }

        if (! addressBookService.isExistUsername(Personname)){
            JOptionPane.showMessageDialog(this, "用户名不存在，请先注册");
            this.resetActionPerformed(e);
            return;
        }


        if (! CheckUtil.checkPassword(password)){
            JOptionPane.showMessageDialog(this, "密码名不符合要求，密码名由5-10位英文字组成");
            this.password.requestFocus();
            return;
        }

        Person Person = new Person();
        Person.setUsername(Personname);
        Person.setPassword(password);

        if (addressBookService.login(Person)){
            JOptionPane.showMessageDialog(this, "登录成功");
            new MainView();
            this.dispose();

        }else {
            JOptionPane.showMessageDialog(this, "登录失败，请重新登录");
            this.resetActionPerformed(e);
            return;
        }
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
        login = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[60,fill]" +
            "[112,fill]" +
            "[51,fill]" +
            "[40,fill]" +
            "[86,fill]" +
            "[88,fill]",
            // rows
            "[55]" +
            "[61]" +
            "[60]" +
            "[62]" +
            "[39]"));

        //---- label1 ----
        label1.setText("Welcome Login Address Book");
        label1.setFont(new Font("Hack", Font.PLAIN, 20));
        contentPane.add(label1, "cell 1 0 4 1,alignx center,growx 0");

        //---- label2 ----
        label2.setFont(new Font("Hack", Font.PLAIN, 13));
        label2.setText("\u59d3\u540d");
        contentPane.add(label2, "cell 1 1,aligny center,growy 0,height 40:40:40");
        contentPane.add(username, "cell 2 1 3 1,aligny center,growy 0,width 300:300:300,height 40:40:40");

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Hack", Font.PLAIN, 20));
        contentPane.add(label3, "cell 1 2");
        contentPane.add(password, "cell 2 2 3 1,width 300:300:300,height 40:40:40");

        //---- register ----
        register.setText("Register");
        register.setFont(new Font("Hack", Font.PLAIN, 16));
        register.addActionListener(e -> registerActionPerformed(e));
        contentPane.add(register, "cell 2 3,aligny center,growy 0");

        //---- reset ----
        reset.setText("Reset");
        reset.setFont(new Font("Hack", Font.PLAIN, 16));
        reset.addActionListener(e -> resetActionPerformed(e));
        contentPane.add(reset, "cell 3 3,aligny center,growy 0");

        //---- login ----
        login.setText("Login");
        login.setFont(new Font("Hack", Font.PLAIN, 16));
        login.addActionListener(e -> loginActionPerformed(e));
        contentPane.add(login, "cell 4 3,aligny center,growy 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
*/