/*
 * Created by JFormDesigner on Fri Jun 07 15:36:07 CST 2019
 */

package com.addressbook.view;

import com.addressbook.bean.AddressBook;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import com.addressbook.util.ViewUtil;
import com.mchange.v2.codegen.bean.BeangenUtils;
import net.miginfocom.swing.MigLayout;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;


/**
 * @author xiaoyou
 */
@SuppressWarnings("ALL")
public class UpdateUserInformationView extends JDialog {

    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

    public static Integer flag = 0;

    public UpdateUserInformationView() {
        initComponents();
        this.setResizable(false);
        this.setModal(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    private void updatePersonActionPerformed(ActionEvent e) {

        AddressBook addressBook = new AddressBook();

        packageAddressBook(addressBook);

        if (flag == 1) {

            boolean b = addressBookService.updateAddressBook(addressBook);
            if (b) {
                JOptionPane.showMessageDialog(this, "更新成功");
                MainView.flag = 1;
                this.setEmpty();
            } else {
                JOptionPane.showMessageDialog(this, "更新失败");
            }
            flag = 0;
        }

    }

    private void cancelActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.dispose();
    }

    private void setEmpty() {
        this.username.setText("");
        this.phone.setText("");
        this.home.setText("");
        this.address.setText("");
        this.birthday.setText("");
        this.email.setText("");
        this.company.setText("");
        this.nickname.setText("");
    }

    private void packageAddressBook(AddressBook addressBook) {

        String username = this.username.getText().trim();
        String sex = String.valueOf(this.sex.getSelectedItem()).trim();
        String phone = this.phone.getText().trim();
        String home = this.home.getText().trim();
        String address = this.address.getText().trim();
        String birthday = this.birthday.getText().trim();
        String userGroup = String.valueOf(this.userGroup.getSelectedItem()).trim();
        String email = this.email.getText().trim();
        String company = this.company.getText().trim();
        String nickname = this.nickname.getText().trim();
        String notes = this.notes.getText().trim();


        if (username == null || username.equals("")) {
            JOptionPane.showMessageDialog(this, "姓名不能为空");
            this.username.requestFocus();
            return;
        }

        if (!CheckUtil.checkUsername(username)) {
            JOptionPane.showMessageDialog(this, "姓名不符合要求");
            this.username.requestFocus();
            return;
        }

        if (!addressBookService.isExistUsername(this.username.getText().trim())) {
            JOptionPane.showMessageDialog(this, "用户名不存在");
            this.username.requestFocus();
            return;
        }

        AddressBook addressBook1 = addressBookService.findOne(this.username.getText().trim());

        if (phone == null || "".equals(phone)) {
            phone = addressBook1.getPhone();
        }

        if (home == null || "".equals(home)) {
            home = addressBook1.getHome();
        }

        if (address == null || "".equals(address)) {
            address = addressBook1.getAddress();
        }

        if (birthday == null || "".equals(birthday)) {
            birthday = addressBook1.getBirthday();
        }

        if (email == null || "".equals(email)) {
            email = addressBook1.getEmail();
        }

        if (company == null || "".equals(company)) {
            company = addressBook1.getCompany();
        }

        if (nickname == null || "".equals(nickname)) {
            nickname = addressBook1.getNickname();
        }

        if (notes == null || "".equals(notes)) {
            notes = addressBook1.getNotes();
        }

        if (CheckUtil.checkPhone(phone)) {
            addressBook.setPhone(phone);
        } else {
            JOptionPane.showMessageDialog(this, "手机号不符合要求");
            this.phone.requestFocus();
            return;
        }

        if (CheckUtil.checkHome(home)) {
            addressBook.setHome(home);
        } else {
            JOptionPane.showMessageDialog(this, "座机号不符合要求");
            this.home.requestFocus();
            return;
        }

        if (CheckUtil.checkBirthday(birthday)) {
            addressBook.setBirthday(birthday);
        } else {
            JOptionPane.showMessageDialog(this, "生日格式不符合要求");
            this.birthday.requestFocus();
            return;
        }

        if (CheckUtil.checkEmail(email)) {
            addressBook.setEmail(email);
        } else {
            JOptionPane.showMessageDialog(this, "邮箱格式不符合要求");
            this.email.requestFocus();
            return;
        }

        addressBook.setUsername(username);
        addressBook.setPhone(phone);
        addressBook.setHome(home);
        addressBook.setAddress(address);
        addressBook.setBirthday(birthday);
        addressBook.setEmail(email);
        addressBook.setCompany(company);
        addressBook.setNickname(nickname);
        addressBook.setNotes(notes);
        addressBook.setSex(sex);
        addressBook.setUsergroup(userGroup);
        flag = 1;
    }

    private void initComponents() {


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - xiaoyou
        label1 = new JLabel();
        label2 = new JLabel();
        username = new JTextField();
        label13 = new JLabel();
        label12 = new JLabel();
        sex = new JComboBox<>();
        label3 = new JLabel();
        phone = new JTextField();
        label14 = new JLabel();
        label4 = new JLabel();
        home = new JTextField();
        label15 = new JLabel();
        label5 = new JLabel();
        address = new JTextField();
        label6 = new JLabel();
        birthday = new JTextField();
        label16 = new JLabel();
        label7 = new JLabel();
        userGroup = new JComboBox<>();
        label8 = new JLabel();
        email = new JTextField();
        label17 = new JLabel();
        label9 = new JLabel();
        company = new JTextField();
        label10 = new JLabel();
        nickname = new JTextField();
        label11 = new JLabel();
        notes = new JTextField();
        addPerson = new JButton();
        cancel = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[29,fill]" +
                        "[70,center]" +
                        "[56,fill]" +
                        "[105,fill]" +
                        "[55,fill]" +
                        "[82,fill]" +
                        "[79,fill]",
                // rows
                "[49]" +
                        "[42]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[59]"));

        //---- label1 ----
        label1.setText("更新通讯录");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label1, "cell 0 0 7 1,alignx center,growx 0");

        //---- label2 ----
        label2.setText(ViewUtil.PERSON_NAME);
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label2, "cell 1 1");
        contentPane.add(username, "cell 2 1 2 1");

        //---- label13 ----
        label13.setText(ViewUtil.NAME_TIPS);
        label13.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label13, "cell 4 1 3 1");

        //---- label12 ----
        label12.setText(ViewUtil.PERSON_SEX);
        label12.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label12, "cell 1 2");

        //---- sex ----
        sex.setModel(new DefaultComboBoxModel<>(new String[]{
                "\u7537",
                "\u5973"
        }));
        sex.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(sex, "cell 2 2 2 1");

        //---- label3 ----
        label3.setText(ViewUtil.PERSON_PHONE);
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label3, "cell 1 3");
        contentPane.add(phone, "cell 2 3 2 1");

        //---- label14 ----
        label14.setText(ViewUtil.PHONE_TIPS);
        label14.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label14, "cell 4 3 3 1");

        //---- label4 ----
        label4.setText(ViewUtil.PERSON_HOME);
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label4, "cell 1 4");
        contentPane.add(home, "cell 2 4 2 1");

        //---- label15 ----
        label15.setText(ViewUtil.HOME_TIPS);
        label15.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label15, "cell 4 4 3 1");

        //---- label5 ----
        label5.setText(ViewUtil.PERSON_ADDRESS);
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label5, "cell 1 5");
        contentPane.add(address, "cell 2 5 2 1");

        //---- label6 ----
        label6.setText(ViewUtil.PERSON_BIRTHDAY);
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label6, "cell 1 6");
        contentPane.add(birthday, "cell 2 6 2 1");

        //---- label16 ----
        label16.setText(ViewUtil.BIRTHDAY_TIPS);
        label16.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label16, "cell 4 6 3 1");

        //---- label7 ----
        label7.setText(ViewUtil.PERSON_USER_GROUP);
        label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label7, "cell 1 7");

        //---- userGroup ----
        userGroup.setModel(new DefaultComboBoxModel<>(new String[]{
                ViewUtil.FAMILY, ViewUtil.FRIEND, ViewUtil.COLLEAGUE, ViewUtil.CLASSMATE, ViewUtil.IMPORTANT_PERSON, ViewUtil.OTHER
        }));
        userGroup.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(userGroup, "cell 2 7 2 1");

        //---- label8 ----
        label8.setText(ViewUtil.PERSON_EMAIL);
        label8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label8, "cell 1 8");
        contentPane.add(email, "cell 2 8 2 1");

        //---- label17 ----
        label17.setText(ViewUtil.EMAIL_TIPS);
        label17.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label17, "cell 4 8 3 1");

        //---- label9 ----
        label9.setText(ViewUtil.PERSON_COMPANY);
        label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label9, "cell 1 9");
        contentPane.add(company, "cell 2 9 2 1");

        //---- label10 ----
        label10.setText(ViewUtil.PERSON_NICKNAME);
        label10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label10, "cell 1 10");
        contentPane.add(nickname, "cell 2 10 2 1");

        //---- label11 ----
        label11.setText(ViewUtil.PERSON_NOTE);
        label11.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label11, "cell 1 11");
        contentPane.add(notes, "cell 2 11 2 1");

        //---- updatePerson ----
        addPerson.setText("更新");
        addPerson.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        addPerson.addActionListener(e -> updatePersonActionPerformed(e));
        contentPane.add(addPerson, "cell 3 12");

        //---- cancel ----
        cancel.setText(ViewUtil.CANCEL);
        cancel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        cancel.addActionListener(e -> cancelActionPerformed(e));
        contentPane.add(cancel, "cell 4 12");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - xiaoyou
    private JLabel label1;
    private JLabel label2;
    private JTextField username;
    private JLabel label13;
    private JLabel label12;
    private JComboBox<String> sex;
    private JLabel label3;
    private JTextField phone;
    private JLabel label14;
    private JLabel label4;
    private JTextField home;
    private JLabel label15;
    private JLabel label5;
    private JTextField address;
    private JLabel label6;
    private JTextField birthday;
    private JLabel label16;
    private JLabel label7;
    private JComboBox<String> userGroup;
    private JLabel label8;
    private JTextField email;
    private JLabel label17;
    private JLabel label9;
    private JTextField company;
    private JLabel label10;
    private JTextField nickname;
    private JLabel label11;
    private JTextField notes;
    private JButton addPerson;
    private JButton cancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
