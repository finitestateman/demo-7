package com.pokemon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<PokemonDto> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{name}")
    public PokemonDto getPokemonByName(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }


}
