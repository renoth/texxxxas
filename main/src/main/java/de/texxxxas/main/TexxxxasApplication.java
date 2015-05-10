package de.texxxxas.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.game.GameParameters;
import de.texxxxas.generator.TexxxxasGenerator;
import de.texxxxas.ui.TexxxxasUi;

import java.io.File;
import java.io.IOException;

public class TexxxxasApplication {
    public static void main(String[] args) {
        System.out.println("\nStarting Application: \n");

        TexxxxasGenerator generator = new TexxxxasGenerator();
        generator.start();

        TexxxxasUi ui = new TexxxxasUi();
        ui.start();

        GameParameters parameters = new GameParameters();

        //TODO set parameters

        TexxxxasGame game = generator.generateGame(parameters);

        //save game

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true); //pretty output
        try {
            mapper.writeValue(new File("game.json"), game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
