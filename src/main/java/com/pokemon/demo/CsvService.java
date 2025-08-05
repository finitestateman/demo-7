package com.pokemon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private PokemonRepo pokemonRepo;

    @Autowired
    private JobStatusRepo jobStatusRepo;

    public void processCsvFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            processFile(filePath);
        }
    }

    @Async
    @Transactional
    public void processFile(String filePath) {
        boolean success = false;
        try (BufferedReader reader = getReaderForFile(filePath)) {
            List<PokemonDto> batch = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming CSV format: name,type,hp,legendary,height,weight,captureDate,stardustCost
                String[] data = line.split(",");
                PokemonDto pokemon = new PokemonDto();
                pokemon.setName(data[0]);
                pokemon.setType(data[1]);
                pokemon.setHp(Integer.parseInt(data[2]));
                pokemon.setLegendary(Boolean.parseBoolean(data[3]));
                pokemon.setHeight(Double.parseDouble(data[4]));
                pokemon.setWeight(Float.parseFloat(data[5]));
                // pokemon.setCaptureDate(LocalDate.parse(data[6]));
                // pokemon.setStardustCost(new BigDecimal(data[7]));
                batch.add(pokemon);

                if (batch.size() >= 100) {
                    pokemonRepo.saveAll(batch);
                    batch.clear();
                }
            }
            if (!batch.isEmpty()) {
                pokemonRepo.saveAll(batch);
            }
            success = true;
        } catch (IOException e) {
            // Log the error
            e.printStackTrace();
        } finally {
            jobStatusRepo.save(new JobStatus(filePath, success));
        }
    }

    private BufferedReader getReaderForFile(String filePath) throws IOException {
        if (new java.io.File(filePath).exists()) {
            return new BufferedReader(new FileReader(filePath));
        } else {
            // Assuming the C# server is running on localhost:5000
            URL url = new URL("http://localhost:5000/csv/" + filePath);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return new BufferedReader(new InputStreamReader(con.getInputStream()));
        }
    }
}
