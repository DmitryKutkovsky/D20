package com.study.D20.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;
import java.io.File;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailService;


    public void send(
            String to, String subject, String text, String pathToAttachment) throws MessagingException {


        MimeMessage message = mailService.createMimeMessage ( );

        MimeMessageHelper helper = new MimeMessageHelper ( message, true );

        helper.setTo ( to );
        helper.setSubject ( subject );
        helper.setText ( text );

        FileSystemResource file
                = new FileSystemResource ( new File ( pathToAttachment ) );
        helper.addAttachment ( "img/invitation.pdf", file );

        mailService.send ( message );

    }
}