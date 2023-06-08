package com.example.SuViet.service;

import com.example.SuViet.model.Character;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterService {
    public List<Character> getAllCharacters();
    public List<Character> findCharactersByName(String search);
}
