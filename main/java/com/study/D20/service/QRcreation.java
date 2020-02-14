package com.study.D20.service;


import java.io.*;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;



public class QRcreation {
    public static void createUserQR (String username){
        ByteArrayOutputStream bout =
                QRCode.from(username)
                        .withSize(150, 150)
                        .to( ImageType.PNG)
                        .stream();

        try {
            OutputStream out = new FileOutputStream ("img/userQR.png");
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}