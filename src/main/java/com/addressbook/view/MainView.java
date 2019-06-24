package com.addressbook.view;

import com.addressbook.bean.AddressBook;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.ViewUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("ALL")
public class MainView extends JFrame {

    private JPanel jPanelNorth;

    private JPanel jPanelCenter;

    private JPanel jPanelSouth;

    private JButton jButtonFind;

    private JButton jButtonAdd;

    private JButton jButtonUpdate;

    private JButton jButtonDelete;

    private JButton jButtonFirst;

    private JButton jButtonPre;

    private JButton jButtonLast;

    private JButton jButtonNext;


    private JLabel jLabelCurrentPageNum;

    private JTextField queryCondition;

    public static JTable jTable;

    private JScrollPane jScrollPane;

    private DefaultTableModel defaultTableModel;

    private static String[] titles = {
            ViewUtil.PERSON_ID, ViewUtil.PERSON_NAME, ViewUtil.PERSON_SEX, ViewUtil.PERSON_PHONE, ViewUtil.PERSON_HOME,
            ViewUtil.PERSON_ADDRESS, ViewUtil.PERSON_BIRTHDAY, ViewUtil.PERSON_USER_GROUP, ViewUtil.PERSON_EMAIL,
            ViewUtil.PERSON_COMPANY, ViewUtil.PERSON_NICKNAME, ViewUtil.PERSON_NOTE};

    private static int currentPageNum = 1;
    public static int pageSize = 5;
    private Page<Object> page;
    public static int pages;

    private AddressBookServiceImpl addressBookService;

    private static final int maxPages = 100;

    public static int flag = 0;

    public MainView() {
        this.init();

    }


    private void init() {

        page = PageHelper.startPage(currentPageNum, pageSize);
        pages = page.getPages();
        this.setTitle(ViewUtil.MAINVIEW_TITLE);

        this.initJpanelNorth();
        this.initJpanelCenter();
        this.initJpanelSourth();

        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);

        this.setBounds(100, 100, 1200, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private void initJpanelNorth() {
        //North Panel
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 5));

        //condition
        queryCondition = new JTextField(ViewUtil.MAINVIEW_FIND_CONDITION);
        queryCondition.addKeyListener(new FindLister());

        //find
        jButtonFind = new JButton(ViewUtil.MAINVIEW_BUTTON_FIND);
        //jButtonFind query by name
        jButtonFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                find();
            }
        });

        //add
        jButtonAdd = new JButton(ViewUtil.MAINVIEW_BUTTON_ADD);

        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddUserInformationView().setVisible(true);

                if (flag == 1) {
                    jButtonLast.doClick(0);
                    flag = 0;
                }
            }
        });

        //update
        jButtonUpdate = new JButton(ViewUtil.MAINVIEW_BUTTON_UPDATE);

        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateUserInformationView();
            }
        });

        //delete
        jButtonDelete = new JButton(ViewUtil.MAINVIEW_BUTTON_DELETE);

        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteUserInformationView();
            }
        });


        jPanelNorth.add(queryCondition);
        jPanelNorth.add(jButtonFind);
        jPanelNorth.add(jButtonAdd);
        jPanelNorth.add(jButtonUpdate);
        jPanelNorth.add(jButtonDelete);
    }

    private void initJpanelCenter() {
        //Center Panel
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 1));

        //init table
        addressBookService = new AddressBookServiceImpl();
        String data[][] = addressBookService.findAllAddressBook();
        pages = page.getPages();
        defaultTableModel = new DefaultTableModel(data, titles);
        jTable = new JTable(defaultTableModel);
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalTextPosition(JLabel.CENTER);
        jTable.setDefaultRenderer(AddressBook.class, defaultTableCellRenderer);
        this.initTable(jTable, data);
        jScrollPane = new JScrollPane(jTable);
        jPanelCenter.add(jScrollPane);
    }

    private void initJpanelSourth() {
        //south Panel
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 5));
        jButtonFirst = new JButton(ViewUtil.MAINVIEW_BUTTON_FIRST);


        jButtonPre = new JButton(ViewUtil.MAINVIEW_BUTTON_PRE);


        jButtonNext = new JButton(ViewUtil.MAINVIEW_BUTTON_NEXT);


        jButtonLast = new JButton(ViewUtil.MAINVIEW_BUTTON_LAST);

        //首页
        jButtonFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageNum = 1;
                PageHelper.startPage(currentPageNum, pageSize);
                String result[][] = addressBookService.findAllAddressBook();
                initTable(jTable, result);
                jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_PAGENUM_JLABEL_DI + currentPageNum + ViewUtil.MAINVIEW_PAGENUM_JLABEL_PAGE);
            }
        });

        //上一页
        jButtonPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageNum--;
                if (currentPageNum <= 0) {
                    currentPageNum = 1;
                }
                PageHelper.startPage(currentPageNum, pageSize);
                String[][] result = addressBookService.findAllAddressBook();
                initTable(jTable, result);
                jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_PAGENUM_JLABEL_DI + currentPageNum + ViewUtil.MAINVIEW_PAGENUM_JLABEL_PAGE);
            }
        });

        //下一页
        jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageNum++;
                if (currentPageNum >= pages) {
                    currentPageNum = pages;
                }

                PageHelper.startPage(currentPageNum, pageSize);

                String[][] result = addressBookService.findAllAddressBook();

                initTable(jTable, result);
                jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_PAGENUM_JLABEL_DI + currentPageNum + ViewUtil.MAINVIEW_PAGENUM_JLABEL_PAGE);
            }
        });

        //末页
        jButtonLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageNum = pages;
                PageHelper.startPage(pages, pageSize);
                String[][] result = addressBookService.findAllAddressBook();
                initTable(jTable, result);
                jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_PAGENUM_JLABEL_DI + currentPageNum + ViewUtil.MAINVIEW_PAGENUM_JLABEL_PAGE);
            }
        });

        jLabelCurrentPageNum = new JLabel(ViewUtil.MAINVIEW_PAGENUM_JLABEL_DI + currentPageNum + ViewUtil.MAINVIEW_PAGENUM_JLABEL_PAGE);
        jLabelCurrentPageNum.setHorizontalAlignment(JLabel.CENTER);

        jPanelSouth.add(jButtonFirst);
        jPanelSouth.add(jButtonPre);
        jPanelSouth.add(jLabelCurrentPageNum);
        jPanelSouth.add(jButtonNext);
        jPanelSouth.add(jButtonLast);
    }


    // query by name
    private void find() {
        String queryParam = this.queryCondition.getText();

        if ("".equals(queryParam) || queryParam == null) {
            JOptionPane.showMessageDialog(this, "查询参数为空");
            this.queryCondition.requestFocus();
            jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_FIND_JLABEL);
            return;
        }
        String result[][] = addressBookService.queryAddressBookByName(queryParam);
        if (result == null) {
            JOptionPane.showMessageDialog(this, "查询结果为空");
        }
        this.queryCondition.setText("");
        this.jLabelCurrentPageNum.setText(ViewUtil.MAINVIEW_FIND_JLABEL);
        initTable(this.jTable, result);
        return;

    }

    //回车发起查询请求
    private class FindLister extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                find();
            }
        }
    }

    //初始化表格
    public void initTable(JTable jTable, String[][] data) {
        ((DefaultTableModel) jTable.getModel()).setDataVector(data, titles);

        jTable.setRowHeight(30);

        TableColumn firstColumn = jTable.getColumnModel().getColumn(0);
        firstColumn.setPreferredWidth(30);
        firstColumn.setMaxWidth(30);
        firstColumn.setMinWidth(30);

        TableColumn secondColumn = jTable.getColumnModel().getColumn(1);
        secondColumn.setPreferredWidth(100);
        secondColumn.setMaxWidth(100);
        secondColumn.setMinWidth(100);

        TableColumn thirdColumn = jTable.getColumnModel().getColumn(2);
        thirdColumn.setPreferredWidth(30);
        thirdColumn.setMaxWidth(30);
        thirdColumn.setMinWidth(30);

        TableColumn forthColumn = jTable.getColumnModel().getColumn(3);
        forthColumn.setPreferredWidth(100);
        forthColumn.setMaxWidth(100);
        forthColumn.setMinWidth(100);

        TableColumn fifthColumn = jTable.getColumnModel().getColumn(4);
        fifthColumn.setPreferredWidth(100);
        fifthColumn.setMaxWidth(100);
        fifthColumn.setMinWidth(100);

        TableColumn sixthColumn = jTable.getColumnModel().getColumn(5);
        sixthColumn.setPreferredWidth(150);
        sixthColumn.setMaxWidth(150);
        sixthColumn.setMinWidth(150);

        TableColumn seventhColumn = jTable.getColumnModel().getColumn(6);
        seventhColumn.setPreferredWidth(100);
        seventhColumn.setMaxWidth(100);
        seventhColumn.setMinWidth(100);

        TableColumn eighthColumn = jTable.getColumnModel().getColumn(7);
        eighthColumn.setPreferredWidth(50);
        eighthColumn.setMaxWidth(50);
        eighthColumn.setMinWidth(50);

        TableColumn ninthColumn = jTable.getColumnModel().getColumn(8);
        ninthColumn.setPreferredWidth(150);
        ninthColumn.setMaxWidth(150);
        ninthColumn.setMinWidth(150);

        TableColumn tenthColumn = jTable.getColumnModel().getColumn(9);
        tenthColumn.setPreferredWidth(100);
        tenthColumn.setMaxWidth(100);
        tenthColumn.setMinWidth(100);

        TableColumn eleventhColumn = jTable.getColumnModel().getColumn(10);
        eleventhColumn.setPreferredWidth(100);
        eleventhColumn.setMaxWidth(100);
        eleventhColumn.setMinWidth(100);

        TableColumn twelvethColumn = jTable.getColumnModel().getColumn(11);
        eleventhColumn.setPreferredWidth(100);
        eleventhColumn.setMaxWidth(100);
        eleventhColumn.setMinWidth(100);

    }
}
