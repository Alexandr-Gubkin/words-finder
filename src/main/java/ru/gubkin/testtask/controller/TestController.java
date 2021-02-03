package ru.gubkin.testtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gubkin.testtask.pojo.Pet;
import ru.gubkin.testtask.service.PetService;

@Controller
public class TestController {

    @Autowired
    PetService petService;

    @GetMapping("/test")
    public String form1(Model model) {
        model.addAttribute("name", new Pet());
        return "test";
    }

    @PostMapping("/testPut")
    public String processForm1(@ModelAttribute Pet pet) {
        petService.putPet(pet);
        return "test";
    }

    @PostMapping("/testfind")
    public String processForm2(@ModelAttribute Pet pet, Model model) {
        String vivod = petService.findName(pet.getName());
        model.addAttribute("vivod", vivod);
        return "test";
    }
}
