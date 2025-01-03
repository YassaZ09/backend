package com.example.polkadanawa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Service.TranslationService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    // English endpoints
    @GetMapping("/english")
    public List<English> getEnglishTranslationsByTopic(@RequestParam String topic) {
        return translationService.getEnglishTranslationsByTopic(topic);
    }

    @PostMapping("/english")
    public English saveEnglishTranslation(@RequestBody English english) {
        return translationService.saveEnglishTranslation(english);
    }

    // Sinhala endpoints
    @GetMapping("/sinhala")
    public List<Sinhala> getSinhalaTranslationsByTopic(@RequestParam String topic) {
        return translationService.getSinhalaTranslationsByTopic(topic);
    }

    @PostMapping("/sinhala")
    public Sinhala saveSinhalaTranslation(@RequestBody Sinhala sinhala) {
        return translationService.saveSinhalaTranslation(sinhala);
    }

    // Tamil endpoints
    @GetMapping("/tamil")
    public List<Tamil> getTamilTranslationsByTopic(@RequestParam String topic) {
        return translationService.getTamilTranslationsByTopic(topic);
    }

    @PostMapping("/tamil")
    public Tamil saveTamilTranslation(@RequestBody Tamil tamil) {
        return translationService.saveTamilTranslation(tamil);
    }
}
