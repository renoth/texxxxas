package de.texxxxas.generator;

import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.game.GameParameters;
import de.texxxxas.common.universe.Universe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class TexxxxasGenerator {
    Logger log = LoggerFactory.getLogger(getClass());

    public void start() {
        System.out.println("Starting Generator ...");
    }

    public TexxxxasGame generateGame(GameParameters parameters) {
        log.info("Generating new game with parameters: " + parameters.toString());

        TexxxxasGame game = new TexxxxasGame();

        game.setStarDate(new Date(2015,1,1));

        Universe universe = new Universe();

        universe.setSize(parameters.getUniverseSize());

        game.setUniverse(universe);

        //TODO set game objects dependent on parameters

        log.info("Done");

        return game;
    }
}
