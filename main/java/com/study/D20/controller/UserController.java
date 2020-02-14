package com.study.D20.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.study.D20.service.PdfCreation;
import com.study.D20.domain.Role;
import com.study.D20.domain.User;
import com.study.D20.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {




    @Autowired
    private UserRepo userRepo;


    @GetMapping
    public String userList(Model model) {
        model.addAttribute ( "users", userRepo.findAll ( ) );
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute ( "user", user );
        model.addAttribute ( "roles", Role.values ( ) );

        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername ( username );

        Set<String> roles = Arrays.stream ( Role.values ( ) )
                .map ( Role::name )
                .collect ( Collectors.toSet ( ) );

        user.getRoles ( ).clear ( );

        for (String key : form.keySet ( )) {
            if (roles.contains ( key )){
                user.getRoles ( ).add ( Role.valueOf ( key ) );
            }
        }


        userRepo.save ( user );

        return "redirect:/user";
    }

}

