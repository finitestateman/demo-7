package com.pokemon.demo;

import org.springframework.web.bind.annotation.RequestParam;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@RestController
@RequestMapping("/csv")
public class CsvGenerationController {

    @GetMapping("/generate")
    public void generateCsv(Writer writer, @RequestParam(defaultValue = "100") int count) throws IOException {
        Faker faker = new Faker();
        try (PrintWriter printWriter = new PrintWriter(writer)) {
            // Header
            printWriter.println("id,name,type,hp,legendary,height,weight,captureDate,stardustCost");
            // Data
            for (int i = 0; i < count; i++) {
                PokemonDto pokemon = new PokemonDto(
                        (long) i,
                        faker.pokemon().name(),
                        faker.pokemon().location(),
                        faker.number().numberBetween(10, 250),
                        faker.bool().bool(),
                        faker.number().randomDouble(2, 1, 100),
                        (float) faker.number().randomDouble(2, 1, 1000),
                        faker.date().birthday().toString(),
                        faker.number().numberBetween(100, 10000)
                );
                printWriter.println(String.format("%d,%s,%s,%d,%b,%.2f,%.2f,%s,%d",
                        pokemon.getId(), pokemon.getName(), pokemon.getType(), pokemon.getHp(),
                        pokemon.isLegendary(), pokemon.getHeight(), pokemon.getWeight(),
                        pokemon.getCaptureDate(), pokemon.getStardustCost()));
            }
        }
    }
}
