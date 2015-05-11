package de.texxxxas.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.game.GameParameters;
import de.texxxxas.common.math.Coordinates;
import de.texxxxas.common.universe.Star;
import de.texxxxas.common.universe.Universe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TexxxxasGenerator {
    static Logger log = LoggerFactory.getLogger(TexxxxasGenerator.class);

    public TexxxxasGame generateGame(GameParameters parameters) {
        log.info("Generating new game with parameters: " + parameters.toString());

        TexxxxasGame game = new TexxxxasGame();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015,1,1);

        game.setStarDate(calendar.getTime());

        Universe universe = new Universe();

        universe.setSize(parameters.getUniverseSize());

        generateStars(universe, parameters.getStarCount());

        game.setUniverse(universe);

        //TODO set game objects dependent on parameters

        log.info("Done");

        return game;
    }

    private void generateStars(Universe universe, int starCount) {
        List<Star> stars = new ArrayList<>();

        for (int i = 1; i <= starCount; i ++) {
            Star s = new Star();
            s.setIdentifier("S" + i);
            s.setCoordinates(new Coordinates(Math.random() * universe.getSize(), Math.random() * universe.getSize()));

            BigDecimal mass = StarGenerator.generateMass();

            Long temperature = StarGenerator.generateTemperature(mass);

            s.setTemperature(temperature);

            log.info(mass.toPlainString());

            s.setMass(mass.toBigInteger());
            stars.add(s);
        }

        for (Star s : stars) {
            universe.getStars().put(s.getIdentifier(), s);
        }
    }

    public TexxxxasGame generateGame() {
        ObjectMapper mapper = new ObjectMapper();

        GameParameters parameters = new GameParameters();
        try {
            parameters = mapper.readValue(new File(System.getProperty("user.dir") + "\\options.json"), GameParameters.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return generateGame(parameters);
    }
}
