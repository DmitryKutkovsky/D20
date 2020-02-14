package com.study.D20.service;


import com.itextpdf.io.IOException;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.text.*;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PdfCreation {
    private static Paragraph paragraph;
    static int FONT_SIZE_SMALL = 16;
    static int FONT_SIZE_BIG = 32;
    static int OFFSET = 40;

   public void createPDF(String username, String firstname, String lastname, String section, String date ) {


        try {
            Document document = new Document (PageSize.A6, 0, 0, 0, 0);

            String fileName = "img/invitation.pdf";
            FileOutputStream fos = new FileOutputStream(fileName);
            PdfWriter.getInstance(document, fos);

            document.open();



            Image top= Image.getInstance("conf_top2.png");
            top.scaleAbsolute(296f, 50f);
            top.setAlignment ( Element.ALIGN_CENTER);
            document.add(top);


            BaseFont bf = BaseFont.createFont("tahoma.ttf", BaseFont.IDENTITY_H, true);

            final Font font = new Font(bf, 10, Font.NORMAL);
            final Font fontb = new Font(bf, 12, Font.BOLD);
            final Font fontsb = new Font(bf, 9, Font.BOLD);


                paragraph = new Paragraph(" ");
                document.add(paragraph);
                paragraph=new Paragraph ( "Пригласительный билет участника конференции",  font );
                paragraph.setAlignment ( Element.ALIGN_CENTER);
                document.add(paragraph);
                paragraph=new Paragraph ( "«ПРАКТИЧЕСКОЕ СТРОИТЕЛЬСТВО»",  font );
                paragraph.setAlignment ( Element.ALIGN_CENTER);
                document.add(paragraph);
                paragraph = new Paragraph(" ");
                document.add(paragraph);
                paragraph=new Paragraph ( firstname +" "+ lastname,  fontb );
                paragraph.setAlignment ( Element.ALIGN_CENTER);
                document.add(paragraph);
                paragraph=new Paragraph ( "«"+section +"»",  font );
                paragraph.setAlignment ( Element.ALIGN_CENTER);
                document.add(paragraph);
                paragraph=new Paragraph ( date,  fontsb );
                paragraph.setAlignment ( Element.ALIGN_CENTER);
                document.add(paragraph);
                paragraph = new Paragraph(" ");
                document.add(paragraph);



            QRcreation.createUserQR ( username );
            Image qr= Image.getInstance("img/userQR.png");
            qr.setAlignment ( Element.ALIGN_CENTER);
            document.add(qr);

            paragraph=new Paragraph ( "Пожалуйста, предъявите QR-код для входа",  font );
            paragraph.setAlignment ( Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph(" ");
            document.add(paragraph);
            paragraph = new Paragraph(" ");
            document.add(paragraph);


            Image bottom= Image.getInstance("conf_top3.png");
            bottom.scaleAbsolute(296f, 20f);
            bottom.setAlignment ( Element.ALIGN_CENTER);
            document.add(bottom);




            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace ( );
        } catch (MalformedURLException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        } catch (java.io.IOException e) {
            e.printStackTrace ( );
        }

   }

}
