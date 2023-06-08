package com.example.SuViet.service.impl;

import com.example.SuViet.model.Character;
import com.example.SuViet.repository.CharacterRepository;
import com.example.SuViet.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> findCharactersByName(String search) {
        return characterRepository.search(search);
    }

    public List<Character> getAllByEnabled(boolean check){
        return characterRepository.findAllByEnabled(check);
    }

}
