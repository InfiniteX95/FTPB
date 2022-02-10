package com.infinite.ftpb;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.infinite.ftpb.frames.MainFrame;
import com.infinite.ftpb.frames.SettingsFrame;
import com.infinite.ftpb.util.ConfigHelper;

public class FTPB {
    public static void main(String[] args){
        System.out.println("Hello World !");
        ConfigHelper.buildConfig();

        FlatDarkLaf.setup();
        MainFrame.startMainFrame();
        //Systray
        SettingsFrame.startSettingsFrame();
    }
}