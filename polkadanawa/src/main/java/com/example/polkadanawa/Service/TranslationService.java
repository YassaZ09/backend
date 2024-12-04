package com.example.polkadanawa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.polkadanawa.Model.*;
import com.example.polkadanawa.Repository.*;
import java.util.List;

@Service
public class TranslationService {

    @Autowired
    private EnglishRepository englishRepository;

    @Autowired
    private SinhalaRepository sinhalaRepository;

    @Autowired
    private TamilRepository tamilRepository;

    // English operations
    public List<English> getEnglishTranslationsByTopic(String topic) {
        return englishRepository.findByTopic(topic);
    }

    public English saveEnglishTranslation(English english) {
        return englishRepository.save(english);
    }

    // Sinhala operations
    public List<Sinhala> getSinhalaTranslationsByTopic(String topic) {
        return sinhalaRepository.findByTopic(topic);
    }

    public Sinhala saveSinhalaTranslation(Sinhala sinhala) {
        return sinhalaRepository.save(sinhala);
    }

    // Tamil operations
    public List<Tamil> getTamilTranslationsByTopic(String topic) {
        return tamilRepository.findByTopic(topic);
    }

    public Tamil saveTamilTranslation(Tamil tamil) {
        return tamilRepository.save(tamil);
    }
}
