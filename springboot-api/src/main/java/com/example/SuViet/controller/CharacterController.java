package com.example.SuViet.controller;

import com.example.SuViet.model.Character;
import com.example.SuViet.model.ResponseObject;
import com.example.SuViet.service.impl.CharacterServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/characters")
public class CharacterController {
    private final CharacterServiceImpl service;

    public CharacterController(CharacterServiceImpl service) {
        this.service = service;
    }
    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllCharacters(){
        List<Character> characterList = service.getAllCharacters();
        return ResponseEntity.status(HttpStatus.OK).body(
            new ResponseObject("OK", "Query successfully!!", characterList)
        );
    }
    @GetMapping("/enabled")
    public ResponseEntity<ResponseObject> getAllCharactersEnabled(){
        List<Character> characterList = service.getAllByEnabled(true);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Query successfully!!", characterList)
        );
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Character> searchCharacterByName(Model model, @RequestParam String keyword){
        List<Character> characterList = service.findCharactersByName(keyword);
        return characterList;
    }


}