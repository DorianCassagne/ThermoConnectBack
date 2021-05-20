package me.dcal.thermoconnect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class Accueil {


    @GetMapping("/")
    public String accueil(Model model) throws ParseException {

        return "index";
    }

}