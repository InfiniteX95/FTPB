package com.infinite.ftpb;

import com.infinite.ftpb.frames.MainFrame;
import com.infinite.ftpb.util.GUIHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SysTrayIcon {
    private static Image iconDisconnected = GUIHelper.getImageFromFiles("/icondisconnected.png");
    private static Image iconConnected = GUIHelper.getImageFromFiles("/iconanim3.gif");

    public static TrayIcon trayicon = new TrayIcon(iconDisconnected);

    public static void createTrayIcon()
    {
        //in case of non Windows users
        if(!SystemTray.isSupported())
        {
            System.out.println("SYSTRAY NOT SUPPORTED !");
        }

        SystemTray tray = SystemTray.getSystemTray();

        PopupMenu menu = new PopupMenu();

        //Menu items
        MenuItem open = new MenuItem("Open");
        MenuItem exit = new MenuItem("Exit");

        //Registers menu items
        menu.add(open);
        menu.add(exit);

        //Trayicon content registerer
        trayicon.setPopupMenu(menu);
        trayicon.setToolTip("FTPB - Disconnected");

        //action listeners for popup menu items
        open.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(MainFrame.frame.isVisible() == false)
                {
                    MainFrame.frame.setVisible(true);
                }
            }
        });

        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tray.remove(trayicon);
                System.exit(0);
            }
        });

        trayicon.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                MainFrame.frame.setVisible(true);
            }
            //useless
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });

        //Adds trayicon
        try
        {
            tray.add(trayicon);
        }
        catch(AWTException e)
        {
            e.printStackTrace();
        }
    }

    /*
     * Updates the trayicon with status codes
     * 0=disconnected, 1=connected
     */
    public static void updateIcon(int status)
    {
        if(status == 0)//Disconnected status
        {
            trayicon.setImage(iconDisconnected);
            trayicon.setToolTip("FTPB - Disconnected");
        }

        if(status == 1)//Connected status
        {
            trayicon.setImage(iconConnected);
            trayicon.setToolTip("FTPB - Connected");
        }
    }
}
