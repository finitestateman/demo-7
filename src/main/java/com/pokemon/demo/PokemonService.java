package com.pokemon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class PokemonService {

    @Autowired
    private PokemonRepo pokemonRepo;

    public List<PokemonDto> getAllPokemons() {
        return pokemonRepo.findAll();
    }

    public PokemonDto getPokemonByName(String name) {
        return pokemonRepo.findByName(name);
    }

}
