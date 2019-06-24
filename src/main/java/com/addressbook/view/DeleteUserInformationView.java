/*
 * Created by JFormDesigner on Fri Jun 07 18:30:13 CST 2019
 */

package com.addressbook.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import net.miginfocom.swing.*;

/**
 * @author xiaoyou
 */

@SuppressWarnings("All")
public class DeleteUserInformationView extends JFrame {
    public DeleteUserInformationView() {
        initComponents();
        this.setVisible(true);
    }

    private void deleteActionPerformed(ActionEvent e) {
        String username = this.username.getText().trim();
        String phone = this.phone.getText().trim();

        AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

        if(username == null || username.equals("")){
            JOptionPane.showMessageDialog(this, "用户名不能为空");
            this.username.requestFocus();
            return;
        }

        if (!CheckUtil.checkUsername(username)){
            JOptionPane.showMessageDialog(this, "用户名不符合要求");
            this.username.requestFocus();
            return;
        }

        if(phone == null || phone.equals("")){
            JOptionPane.showMessageDialog(this, "手机号不能为空");
            this.phone.requestFocus();
            return;
        }

        if (!CheckUtil.checkPhone(phone)){
            JOptionPane.showMessageDialog(this, "手机号不符合要求");
            this.phone.requestFocus();
            return;
        }

        if (!addressBookService.isExistUsername(username)){
            JOptionPane.showMessageDialog(this, "用户名不存在");
            this.phone.requestFocus();
            return;
        }

        if (!addressBookService.isExistPhone(phone)){
            JOptionPane.showMessageDialog(this, "手机号不存在");
            this.phone.requestFocus();
            return;
        }


        boolean b = addressBookService.deleteAddressBookByName(username, phone);
        if (b){
            JOptionPane.showMessageDialog(this, "删除成功");
        }else {
            JOptionPane.showMessageDialog(this, "删除失败");
        }
        this.dispose();
    }

    private void cancelActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xiaoyou
        label1 = new JLabel();
        label2 = new JLabel();
        username = new JTextField();
        label3 = new JLabel();
        phone = new JTextField();
        delete = new JButton();
        cancel = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[35,fill]" +
            "[91,fill]" +
            "[98,fill]" +
            "[104,fill]" +
            "[57,fill]",
            // rows
            "[42]" +
            "[55]" +
            "[48]" +
            "[51]" +
            "[34]"));

        //---- label1 ----
        label1.setText("\u5220\u9664\u901a\u8baf\u5f55");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label1, "cell 0 0 5 1,alignx center,growx 0");

        //---- label2 ----
        label2.setText("\u59d3\u540d");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label2, "cell 1 1,alignx center,growx 0");
        contentPane.add(username, "cell 2 1 2 1");

        //---- label3 ----
        label3.setText("\u624b\u673a\u53f7");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label3, "cell 1 2,alignx center,growx 0");
        contentPane.add(phone, "cell 2 2 2 1");

        //---- delete ----
        delete.setText("\u5220\u9664");
        delete.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        delete.addActionListener(e -> deleteActionPerformed(e));
        contentPane.add(delete, "cell 2 3");

        //---- cancel ----
        cancel.setText("\u53d6\u6d88");
        cancel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        cancel.addActionListener(e -> cancelActionPerformed(e));
        contentPane.add(cancel, "cell 3 3");
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
    private JTextField phone;
    private JButton delete;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
