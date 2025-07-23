package com.pokemon.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepo extends JpaRepository<PokemonDto, Long> {
    PokemonDto findByName(String name);
}
