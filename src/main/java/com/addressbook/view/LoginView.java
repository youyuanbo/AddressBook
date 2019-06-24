/*
 * Created by JFormDesigner on Fri Jun 07 20:53:12 CST 2019
 */

package com.addressbook.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.addressbook.bean.User;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.service.impl.UserServiceImpl;
import com.addressbook.util.CheckUtil;
import net.miginfocom.swing.*;

/**
 * @author xiaoyou
 */

@SuppressWarnings("ALL")
public class LoginView extends JFrame {

//    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    public LoginView() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void registerActionPerformed(ActionEvent e) {
        // TODO add your code here
        RegisterView registerView = new RegisterView();
        this.dispose();
        registerView.setVisible(true);

    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.username.setText("");
        this.password.setText("");
    }

    private void loginActionPerformed(ActionEvent e) {
        // TODO add your code here
        String Personname = this.username.getText().trim();
        String password = String.valueOf(this.password.getPassword()).trim();


        if (!CheckUtil.checkUsername(Personname)){
            JOptionPane.showMessageDialog(this, "用户名不符合要求，用户名由5-10位英文字组成");
            this.username.requestFocus();
            return;
        }

        if (! userService.isExistUsername(Personname)){
            JOptionPane.showMessageDialog(this, "用户名不存在，请先注册");
            this.resetActionPerformed(e);
            return;
        }


        if (! CheckUtil.checkPassword(password)){
            JOptionPane.showMessageDialog(this, "密码名不符合要求，密码名由5-10位英文字组成");
            this.password.requestFocus();
            return;
        }

        User user = new User();
        user.setUsername(Personname);
        user.setPassword(password);

        if (userService.login(user)){
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
            "[49,fill]" +
            "[60,fill]" +
            "[52,fill]" +
            "[fill]" +
            "[57,fill]" +
            "[68,fill]",
            // rows
            "[61]" +
            "[49]" +
            "[64]" +
            "[39]" +
            "[50]"));

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u767b\u5f55");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 16f));
        contentPane.add(label1, "cell 0 0 6 1,alignx center,growx 0");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));
        contentPane.add(label2, "cell 1 1,alignx center,growx 0");
        contentPane.add(username, "cell 2 1 3 1,aligny center,growy 0,height 40:40:40");

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 10f));
        contentPane.add(label3, "cell 1 2,align center center,grow 0 0");
        contentPane.add(password, "cell 2 2 3 1,height 40:40:40");

        //---- register ----
        register.setText("\u6ce8\u518c");
        register.setFont(register.getFont().deriveFont(register.getFont().getSize() + 10f));
        register.addActionListener(e -> registerActionPerformed(e));
        contentPane.add(register, "cell 2 3,alignx center,growx 0");

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.setFont(reset.getFont().deriveFont(reset.getFont().getSize() + 10f));
        reset.addActionListener(e -> resetActionPerformed(e));
        contentPane.add(reset, "cell 3 3,alignx center,growx 0");

        //---- login ----
        login.setText("\u767b\u5f55");
        login.setFont(login.getFont().deriveFont(login.getFont().getSize() + 10f));
        login.addActionListener(e -> loginActionPerformed(e));
        contentPane.add(login, "cell 4 3,alignx center,growx 0");
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
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
