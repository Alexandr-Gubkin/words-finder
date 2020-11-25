package ru.gubkin.testtask.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import ru.gubkin.testtask.pojo.Word;
import ru.gubkin.testtask.service.WordsFinder;

import java.util.List;

@Controller
public class WordsController {

    @Autowired
    WordsFinder wordsFinder;

    @GetMapping("/index")
    public String form(Model model) {
        model.addAttribute("word", new Word());
        return "index";
    }

    @PostMapping("/index")
    public String processForm(@ModelAttribute Word word, Model model) {
        List<String> arrayList = wordsFinder.findWords(word.getContent());
        model.addAttribute("result", arrayList);
        return "index";
    }
}
