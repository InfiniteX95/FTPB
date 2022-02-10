package com.infinite.ftpb.util;

import javax.swing.*;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GUIHelper {
    public static final Image pIcon16 = createImageIcon("/ftpb16px.png");
    public static final Image pIcon32 = createImageIcon("/ftpb32px.png");
    public static final Image pIcon96 = createImageIcon("/ftpb96px.png");

    //creates a list of existing icons
    public static List<Image> getProgramIcon() {
        List<Image> images = new ArrayList<>();
        images.add(pIcon16);
        images.add(pIcon32);
        images.add(pIcon96);

        return images;
    }

    //Gets an image with its path
    public static Image createImageIcon(String path) {
        URL imageURL = GUIHelper.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, "")).getImage();
        }
    }
}