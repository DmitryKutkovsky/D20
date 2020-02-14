package com.study.D20.controller;

import com.study.D20.domain.Role;
import com.study.D20.domain.User;
import com.study.D20.repos.UserRepo;
import com.study.D20.service.MailService;
import com.study.D20.service.PdfCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Map;

@EnableScheduling
@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailService mailService;



    @GetMapping("/registration")
    public String registration(Model model)
    {
        model.addAttribute("message", "");
        return ("/registration");
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) throws FileNotFoundException, MalformedURLException, MessagingException {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        if (user.getUsername ()!=null) {
            PdfCreation pdf=new PdfCreation ();
            pdf.createPDF (user.getUsername (), user.getFirstname (), user.getLastname(), user.getSection (), user.getDate ());
            }

     if (!StringUtils.isEmpty(user.getUsername())) {
            String message = "Здравствуйте, "+user.getFirstname ()+ "!"
                    + "Спасибо за регистрацию. Ваш билет во вложении. " +
                    "Пожалуйста, покажите его на экране смартфона или распечатайте. ";
            String subject="Ваш билет на коференцию «Практическое строительство»";
            String mailTo=user.getUsername ();
            String pathToAttachment="img/invitation.pdf";

            mailService.send(mailTo, subject, message, pathToAttachment);
        }



        user.setActive(true);
        user.setRoles(Collections.singleton( Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
