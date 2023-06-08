package com.example.SuViet.repository;

import com.example.SuViet.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    public List<Character> findAllByEnabled(boolean enabled);
    @Query("SELECT u FROM Character u WHERE u.characterName LIKE %?1%")
    public List<Character> search(String keyword);
}
