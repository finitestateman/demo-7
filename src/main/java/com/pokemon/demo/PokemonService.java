package com.pokemon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepo pokemonRepo;

    public PokemonDto createPokemon(PokemonDto pokemon) {
        return pokemonRepo.save(pokemon);
    }

    public List<PokemonDto> getAllPokemons() {
        return pokemonRepo.findAll();
    }

    public PokemonDto getPokemonById(Long id) {
        return pokemonRepo.findById(id).orElse(null);
    }

    public PokemonDto updatePokemon(Long id, PokemonDto pokemonDetails) {
        PokemonDto pokemon = pokemonRepo.findById(id).orElse(null);
        if (pokemon != null) {
            pokemon.setName(pokemonDetails.getName());
            pokemon.setType(pokemonDetails.getType());
            pokemon.setHp(pokemonDetails.getHp());
            pokemon.setLegendary(pokemonDetails.isLegendary());
            pokemon.setHeight(pokemonDetails.getHeight());
            pokemon.setWeight(pokemonDetails.getWeight());
            pokemon.setCaptureDate(pokemonDetails.getCaptureDate());
            pokemon.setStardustCost(pokemonDetails.getStardustCost());
            pokemon.setPicture(pokemonDetails.getPicture());
            return pokemonRepo.save(pokemon);
        }
        return null;
    }

    public void deletePokemon(Long id) {
        pokemonRepo.deleteById(id);
    }

    public PokemonDto getPokemonByName(String name) {
        return pokemonRepo.findByName(name);
    }

}
