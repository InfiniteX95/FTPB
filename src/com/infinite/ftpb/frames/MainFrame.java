/*
 * Created by JFormDesigner on Sat Dec 18 14:54:21 CET 2021
 */

package com.infinite.ftpb.frames;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.infinite.ftpb.util.ClockHelper;
import com.infinite.ftpb.util.ConfigHelper;
import com.infinite.ftpb.util.FTPHelper;
import com.infinite.ftpb.util.GUIHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Infinite
 */
public class MainFrame extends JFrame {

    public static MainFrame frame;

    public MainFrame() {
        initComponents();
        setIconImages(GUIHelper.getProgramIcon());
        setEvents();
        addClientMsgToConsole("FTPB Client Started !");
    }

    public static void startMainFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    frame = new MainFrame();
                    frame.setVisible(true);
                }
                catch(Exception e)
                {
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

    public JTextPane getConsolePane() {
        return consolePane;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane = new JScrollPane();
        consolePane = new JTextPane();
        btnSettings = new JButton();
        btnBackup = new JButton();
        btnConnect = new JButton();
        btnDisconnect = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(540, 300));
        setTitle("FTPB");
        Container contentPane = getContentPane();

        //======== scrollPane ========
        {
            scrollPane.setToolTipText("FTPB");
            scrollPane.setAutoscrolls(true);

            //---- consolePane ----
            consolePane.setFont(new Font("Consolas", Font.PLAIN, 12));
            consolePane.setForeground(Color.green);
            consolePane.setEditable(false);
            scrollPane.setViewportView(consolePane);
        }

        //---- btnSettings ----
        btnSettings.setText("Settings");

        //---- btnBackup ----
        btnBackup.setText("Backup Now !");

        //---- btnConnect ----
        btnConnect.setText("Connect");

        //---- btnDisconnect ----
        btnDisconnect.setText("Disconnect");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(btnSettings)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnConnect)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDisconnect)
                            .addGap(0, 270, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                                .addComponent(btnBackup, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSettings)
                        .addComponent(btnConnect)
                        .addComponent(btnDisconnect))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnBackup)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane;
    private JTextPane consolePane;
    private JButton btnSettings;
    private JButton btnBackup;
    private JButton btnConnect;
    private JButton btnDisconnect;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void setEvents(){
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigHelper helper = new ConfigHelper();
                //connect to ftp
            }
        });
        btnDisconnect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //disconnect to ftp
            }
        });
        btnSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                SettingsFrame.frame.setVisible(true);
            }
        });
        btnBackup.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ConfigHelper helper = new ConfigHelper();

                //String fileLocalPath = new String(helper.getProp("localpath") + "\\");

                //FTPAccess.backup(helper.getProp("path"), fileLocalPath);
            }
        });
    }

    public void addTextToConsole(String txt)
    {
        getConsolePane().setText(consolePane.getText() + txt + "\n");
    }

    public void addServerMsgToConsole(String txt)
    {
        getConsolePane().setText(consolePane.getText() + "[" + ClockHelper.getActualHour() + "] SERVER : " + txt + "\n");
    }

    public void addClientMsgToConsole(String txt)
    {
        getConsolePane().setText(consolePane.getText() + "[" + ClockHelper.getActualHour() + "] CLIENT : " + txt + "\n");
    }
}
