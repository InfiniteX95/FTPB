package com.infinite.ftpb.util;

import com.infinite.ftpb.frames.MainFrame;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class FTPHelper {
    public static FTPClient client = new FTPClient();

    //Show server replies to the console frame
    private static void showServerReply(FTPClient ftpClient){
        String[] replies = ftpClient.getReplyStrings();

        if (replies != null && replies.length > 0){
            for (String reply : replies){
                MainFrame.frame.addServerMsgToConsole(reply);
            }
        }
    }

    //Logs the client to the FTP server with given informations
    public static void FTPLogin(String adress, String user, String pass, int port){
        if(!client.isConnected()){
            try{
                client.connect(adress, port);
                showServerReply(client);
                int replyCode = client.getReplyCode();

                if(!FTPReply.isPositiveCompletion(replyCode)){
                    return;
                }
                boolean success = client.login(user, pass);

                showServerReply(client);

                if(!success){
                    MainFrame.frame.addClientMsgToConsole("Could not login to the server.");
                    return;
                }
                else{
                    MainFrame.frame.addClientMsgToConsole("Successfully logged into the server !");
                    //update the systray icon
                }
            } catch (SocketException e) {
                MainFrame.frame.addClientMsgToConsole("Network error : can't connect to " + adress);
                e.printStackTrace();
            } catch (IOException e) {
                MainFrame.frame.addClientMsgToConsole("I/O error : can't send or get a command to/from the server");
                e.printStackTrace();
            }
        }
    }

    //Disconnects the client from the FTP server
    public static void FTPDisconnect(){
        if(client.isConnected()){
            try{
                client.disconnect();
                MainFrame.frame.addClientMsgToConsole("Disconnected from the server");
                //update systray icon
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Downloads all the files recursively and creates directories if the path corresponds to one
    public static void FTPDownload(String remotePath, String localPath) throws IOException{
        FTPFile[] remoteFiles = client.listFiles(remotePath);

        for(FTPFile remoteFile : remoteFiles){
            if(!remoteFile.getName().equals(".") && !remoteFile.getName().equals("..")){
                String remoteFilePath = remotePath + "\\" + remoteFile.getName();
                String localFilePath = localPath + "\\" + remoteFile.getName();

                if(remoteFile.isDirectory()){
                    new File(localFilePath).mkdirs();
                    FTPDownload(remoteFilePath, localFilePath);
                }else{
                    MainFrame.frame.addClientMsgToConsole("Downloading file " + remoteFilePath + " to " + localFilePath);

                    OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFilePath));
                    if(!client.retrieveFile(remoteFilePath, outputStream)){
                        MainFrame.frame.addClientMsgToConsole("Failed to download file " + remoteFilePath);
                    }
                    outputStream.close();
                }
            }
        }
    }

    //Initiates a proper backup
    public static void backup(String remotePath, String localPath) {
        if(client.isConnected()) {
            MainFrame.frame.addClientMsgToConsole("Backup started...");
            try {
                ConfigHelper helper = new ConfigHelper();

                if(helper.getProp("useDateTime").equals("true")) {

                    String dateTime = ClockHelper.getFormattedDateTime();
                    System.out.println("PATH: " + localPath + (localPath.charAt(localPath.length()-1) == '\\'));
                    localPath = (localPath.charAt(localPath.length()-1) == '\\') ? (localPath + dateTime) : (localPath + " " + dateTime);
                    System.out.println("PATH2: " + localPath);

                    System.out.println("FOLDER : " + localPath);
                    File directory = new File(localPath);

                    if(!directory.exists()) {
                        directory.mkdirs();
                    }

                    FTPDownload(remotePath, localPath);
                } else {
                    File directory = new File(localPath);
                    if(!directory.exists()) {
                        directory.mkdirs();
                    }

                    FTPDownload(remotePath, localPath);
                }
                MainFrame.frame.addClientMsgToConsole("Backup finished.");
            }
            catch(IOException e) {
                MainFrame.frame.addClientMsgToConsole("An unexpected error occured while trying to download files...");
                e.printStackTrace();
            }
        }
        else {
            MainFrame.frame.addClientMsgToConsole("Can't backup files if the client isn't connected to any server.");
        }
    }
}