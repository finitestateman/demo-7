package com.pokemon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public PokemonDto createPokemon(@RequestBody PokemonDto pokemon) {
        return pokemonService.createPokemon(pokemon);
    }

    @GetMapping
    public List<PokemonDto> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{id}")
    public PokemonDto getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id);
    }

    @PutMapping("/{id}")
    public PokemonDto updatePokemon(@PathVariable Long id, @RequestBody PokemonDto pokemonDetails) {
        return pokemonService.updatePokemon(id, pokemonDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
    }
}
