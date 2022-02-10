/*
 * Created by JFormDesigner on Sat Dec 18 14:56:18 CET 2021
 */

package com.infinite.ftpb.frames;

import com.formdev.flatlaf.FlatDarkLaf;
import com.infinite.ftpb.util.ConfigHelper;
import com.infinite.ftpb.util.GUIHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Infinite
 */
public class SettingsFrame extends JFrame {

    public static SettingsFrame frame;

    public SettingsFrame() {
        initComponents();
        setIconImages(GUIHelper.getProgramIcon());
        setEvents();
        fillConfigInfo();
    }

    public static void startSettingsFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new SettingsFrame();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblAdress = new JLabel();
        textFieldAdress = new JTextField();
        lblPort = new JLabel();
        textFieldPort = new JTextField();
        labelUsername = new JLabel();
        textFieldUsername = new JTextField();
        labelPassword = new JLabel();
        passwordField = new JPasswordField();
        labelFTPPath = new JLabel();
        textFieldFTPPath = new JTextField();
        btnFTPBrowse = new JButton();
        labelFieldLocalPath = new JLabel();
        textFieldLocalPath = new JTextField();
        btnLocalBrowse = new JButton();
        checkBoxDateTime = new JCheckBox();
        checkBoxZIP = new JCheckBox();
        btnExit = new JButton();
        btnSave = new JButton();
        comboBoxProtocol = new JComboBox();
        labelProtocol = new JLabel();

        //======== this ========
        setTitle("Settings");
        setResizable(false);
        Container contentPane = getContentPane();

        //---- lblAdress ----
        lblAdress.setText("Adress : ");

        //---- lblPort ----
        lblPort.setText("Port : ");

        //---- labelUsername ----
        labelUsername.setText("Username : ");

        //---- labelPassword ----
        labelPassword.setText("Password : ");

        //---- labelFTPPath ----
        labelFTPPath.setText("FTP Path : ");
        labelFTPPath.setToolTipText("FTP Path, empty = root");

        //---- btnFTPBrowse ----
        btnFTPBrowse.setText("Browse...");

        //---- labelFieldLocalPath ----
        labelFieldLocalPath.setText("Local Path : ");

        //---- btnLocalBrowse ----
        btnLocalBrowse.setText("Browse...");

        //---- checkBoxDateTime ----
        checkBoxDateTime.setText("Create new dir with date and time");

        //---- checkBoxZIP ----
        checkBoxZIP.setText("ZIP");

        //---- btnExit ----
        btnExit.setText("Exit");

        //---- btnSave ----
        btnSave.setText("Save");

        //---- labelProtocol ----
        labelProtocol.setText("Protocol :");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(lblAdress)
                                .addComponent(labelUsername)
                                .addComponent(labelFTPPath)
                                .addComponent(labelFieldLocalPath))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textFieldLocalPath, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnLocalBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textFieldFTPPath, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnFTPBrowse, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(textFieldUsername, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(0, 35, Short.MAX_VALUE)
                                            .addComponent(lblPort))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                            .addComponent(labelPassword)))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(textFieldPort, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(checkBoxDateTime)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(labelProtocol)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBoxProtocol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 49, Short.MAX_VALUE)
                                    .addComponent(btnSave)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExit))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(checkBoxZIP)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGap(12, 12, 12))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAdress)
                        .addComponent(lblPort))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelUsername)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPassword))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldFTPPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelFTPPath)
                        .addComponent(btnFTPBrowse))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldLocalPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLocalBrowse)
                        .addComponent(labelFieldLocalPath))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(checkBoxDateTime)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelProtocol)
                                .addComponent(comboBoxProtocol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(checkBoxZIP)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSave)
                                .addComponent(btnExit))
                            .addGap(14, 14, 14))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblAdress;
    private JTextField textFieldAdress;
    private JLabel lblPort;
    private JTextField textFieldPort;
    private JLabel labelUsername;
    private JTextField textFieldUsername;
    private JLabel labelPassword;
    private JPasswordField passwordField;
    private JLabel labelFTPPath;
    private JTextField textFieldFTPPath;
    private JButton btnFTPBrowse;
    private JLabel labelFieldLocalPath;
    private JTextField textFieldLocalPath;
    private JButton btnLocalBrowse;
    private JCheckBox checkBoxDateTime;
    private JCheckBox checkBoxZIP;
    private JButton btnExit;
    private JButton btnSave;
    private JComboBox comboBoxProtocol;
    private JLabel labelProtocol;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void fillConfigInfo(){
        ConfigHelper helper = new ConfigHelper();

        textFieldAdress.setText(helper.getProp("adress"));
        textFieldUsername.setText(helper.getProp("username"));
        textFieldPort.setText(helper.getProp("port"));
        passwordField.setText(helper.getProp("password"));
        textFieldFTPPath.setText(helper.getProp("path"));
        textFieldLocalPath.setText(helper.getProp("localpath"));
        checkBoxDateTime.setSelected(helper.getProp("useDateTime").equals("true") ? true : false);
        String[] protocols = {"FTP","SFTP"};
        for (String p : protocols) {
            comboBoxProtocol.addItem(p.toString());
        }
    }

    private void setEvents(){
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConfigHelper helper = new ConfigHelper();

                helper.setProp("adress", textFieldAdress.getText());
                helper.setProp("username", textFieldUsername.getText());
                helper.setProp("port", textFieldPort.getText());
                helper.setProp("password", passwordField.getText());
                helper.setProp("path", textFieldFTPPath.getText());
                helper.setProp("localpath", textFieldLocalPath.getText());
                helper.setProp("useDateTime", Boolean.toString(checkBoxDateTime.isSelected()));
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                fillConfigInfo();
            }
        });

        btnFTPBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnLocalBrowse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser browse = new JFileChooser(textFieldLocalPath.getText());
                browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = browse.showOpenDialog(frame);

                if(option == JFileChooser.APPROVE_OPTION) {
                    System.out.println("selected folder : " + browse.getSelectedFile().getAbsolutePath());
                    textFieldLocalPath.setText(browse.getSelectedFile().getAbsolutePath());
                }
            }
        });

        textFieldFTPPath.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                /*
                String text = textFieldFTPPath.getText();
                if(text.length() >= 1)
                {
                    if(text.charAt(text.length()-1) == '\\')
                    {
                        textFieldFTPPath.setText(text.substring(0, text.length()-1));
                    }
                }*/
            }

            public void focusGained(FocusEvent e){}
        });

        textFieldLocalPath.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                /*
                String text = textFieldLocalPath.getText();
                if(text.length() >= 1)
                {
                    if(text.charAt(text.length()-1) == '\\')
                    {
                        textFieldLocalPath.setText(text.substring(0, text.length()-1));
                    }
                }*/
            }
            public void focusGained(FocusEvent e){}
        });
    }
}