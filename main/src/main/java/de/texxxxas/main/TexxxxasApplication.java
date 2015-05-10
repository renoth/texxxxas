package de.texxxxas.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.game.GameParameters;
import de.texxxxas.generator.TexxxxasGenerator;
import de.texxxxas.ui.TexxxxasUi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class TexxxxasApplication {

    static Logger log = LoggerFactory.getLogger(TexxxxasApplication.class);

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("\nStarting Application: \n");

        TexxxxasGenerator generator = new TexxxxasGenerator();
        generator.start();

        TexxxxasUi ui = new TexxxxasUi();
        ui.start();

        GameParameters parameters = new GameParameters();
        try {
            parameters = mapper.readValue(new File(System.getProperty("user.dir") + "\\options.json"), GameParameters.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO set parameters

        TexxxxasGame game = generator.generateGame(parameters);

        //save game


        mapper.configure(SerializationFeature.INDENT_OUTPUT, true); //pretty output
        try {
            mapper.writeValue(new File(System.getProperty("user.dir") + "\\game.json"), game);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
