/*
 * Created by JFormDesigner on Fri Jun 07 21:03:45 CST 2019
 */

package com.addressbook.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.addressbook.bean.Person;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import net.miginfocom.swing.*;

/**
 * @author xiaoyou
 */
@SuppressWarnings("ALL")
public class RegisterView extends JFrame {

    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

    LoginView loginView = new LoginView();

    public RegisterView() {
        initComponents();
    }


    private void registerActionPerformed(ActionEvent e) {
        // TODO add your code here

        //1. 获取用户名与密码
        String username = this.username.getText().trim();
        StringBuffer passwordBuffer = new StringBuffer();
        String password = String.valueOf(this.password.getPassword()).trim();

        //2. 校验数据

        if (!CheckUtil.checkUsername(username)){
            JOptionPane.showMessageDialog(this, "用户名不符合要求，用户名由5-10位英文字组成");
            this.username.requestFocus();
            return;
        }

        if (addressBookService.isExistUsername(username)){
            JOptionPane.showMessageDialog(this, "用户名已经被注册，请重新输入");
            this.username.requestFocus();
            return;
        }

        if (! CheckUtil.checkPassword(password)){
            JOptionPane.showMessageDialog(this, "密码名不符合要求，密码名由5-10位英文字组成");
            this.password.requestFocus();
            return;
        }

        //3. 封装成对象

        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        //4. 注册
        boolean register = addressBookService.register(person);
        //5. 返回登录界面
        if (register){
            JOptionPane.showMessageDialog(this, "注册成功，将返回登录界面");
            this.dispose();
            loginView.setVisible(true);
        }
    }

    private void resetActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.username.setText("");
        this.password.setText("");
    }

    private void cancelActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        loginView.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
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
            "[58,fill]" +
            "[67,fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[55,fill]",
            // rows
            "[57]" +
            "[55]" +
            "[52]" +
            "[71]" +
            "[34]"));

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u754c\u9762");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        contentPane.add(label1, "cell 0 0 6 1,alignx center,growx 0");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 12f));
        contentPane.add(label2, "cell 1 1");
        contentPane.add(username, "cell 2 1 3 1,height 40:40:40");

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 12f));
        contentPane.add(label3, "cell 1 2");
        contentPane.add(password, "cell 2 2 3 1,height 40:40:40");

        //---- register ----
        register.setText("\u6ce8\u518c");
        register.setFont(register.getFont().deriveFont(register.getFont().getSize() + 12f));
        register.addActionListener(e -> {
			button1ActionPerformed(e);
			registerActionPerformed(e);
		});
        contentPane.add(register, "cell 2 3");

        //---- reset ----
        reset.setText("\u91cd\u7f6e");
        reset.setFont(reset.getFont().deriveFont(reset.getFont().getSize() + 12f));
        reset.addActionListener(e -> {
			button2ActionPerformed(e);
			resetActionPerformed(e);
		});
        contentPane.add(reset, "cell 3 3");

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.setFont(cancel.getFont().deriveFont(cancel.getFont().getSize() + 12f));
        cancel.addActionListener(e -> {
			button3ActionPerformed(e);
			cancelActionPerformed(e);
		});
        contentPane.add(cancel, "cell 4 3");
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
