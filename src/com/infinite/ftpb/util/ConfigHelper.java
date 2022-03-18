package com.infinite.ftpb.util;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

public class ConfigHelper {
    public static Properties prop = new Properties();

    public static String directoryPath = System.getProperty("user.home") + "\\AppData\\Local\\FTPB";
    public static String cfgPath = directoryPath + "\\config.properties";

    public static void buildConfig(){
        File directory = new File(directoryPath);

        //Create a FTPB folder in User's Local directory if it doesn't exist
        if (!directory.exists()) {
            System.out.println("Internal Info : Directory created");
            directory.mkdir();
        }

        File cfg = new File(cfgPath);

        if (!cfg.exists()) {
            System.out.println("Internal Info : Config file created");
            try{
                //setting property values
                prop.setProperty("adress","0.0.0.0");
                prop.setProperty("username","user");
                prop.setProperty("password","");
                prop.setProperty("port","21");
                prop.setProperty("path","\\");
                prop.setProperty("localpath","C:\\FTPB");
                prop.setProperty("useDateTime","false");
                prop.setProperty("protocol","0");

                //saving properties to project root folder
                prop.store(new FileOutputStream(cfgPath), null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getStackTrace().toString());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getStackTrace().toString());
            }
        }
    }

    public void setProp(String key, String value) {
        File cfg = new File(cfgPath);
        try{
            prop.setProperty(key, value);
            prop.store(new FileOutputStream(cfgPath), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getStackTrace().toString());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getStackTrace().toString());
        }
    }

    public String getProp(String key) {
        File cfg = new File(cfgPath);
        try{
            //load the file
            prop.load(new FileInputStream(cfgPath));

            System.out.println("new value get : " + key + ", " + prop.getProperty(key));

            return prop.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Internal Error : Couldn't get " + key + " prop from file : " + cfgPath;
    }
}