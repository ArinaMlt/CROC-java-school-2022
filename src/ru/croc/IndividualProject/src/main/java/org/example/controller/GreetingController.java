package org.example.controller;

import com.darkprograms.speech.translator.GoogleTranslate;
import org.example.domain.Word;
import org.example.repo.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private WordRepo wordRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Word> words = wordRepo.findAll();
//        words
        model.put("words", words);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, Map<String, Object> model) {
        String trText = text;

        try {
            trText = GoogleTranslate.translate("ru", text);
//            System.out.println(GoogleTranslate.translate("r", "how are you"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Word word = new Word(text,trText);
        wordRepo.save(word);
        Iterable<Word> words = wordRepo.findAll();
        model.put("words", words);
        return "main";
    }

}
