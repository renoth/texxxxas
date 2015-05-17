package de.texxxxas.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.faction.Colony;
import de.texxxxas.common.faction.Faction;
import de.texxxxas.common.game.GameParameters;
import de.texxxxas.common.math.Coordinates;
import de.texxxxas.common.universe.Planet;
import de.texxxxas.common.universe.Star;
import de.texxxxas.common.universe.Universe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TexxxxasGenerator {
    static Logger log = LoggerFactory.getLogger(TexxxxasGenerator.class);
    static Random random = new Random();

    public TexxxxasGame generateGame() {
        ObjectMapper mapper = new ObjectMapper();

        GameParameters parameters = GameParameters.getCurrentGameParameters();

/*        try {
            parameters = mapper.readValue(new File(System.getProperty("user.dir") + "\\options.json"), GameParameters.class);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return generateGame(parameters);
    }

    public TexxxxasGame generateGame(GameParameters parameters) {
        log.info("Generating new game with parameters: " + parameters.toString());

        TexxxxasGame game = new TexxxxasGame();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015,1,1);

        game.setStarDate(calendar.getTime());

        Universe universe = new Universe();

        universe.setSize(parameters.getUniverseSize());

        generateStars(universe, parameters);

        game.setUniverse(universe);

        //TODO set game objects dependent on parameters

        log.info("Done");

        Faction player = new Faction();

        player.setName("Player");
        player.setKnowledge(KnowledgeGenerator.startKnowledge());

        Planet homeworld = universe.getStars().get("S2").getPlanets().get(0);

        homeworld.setColony(new Colony(player, homeworld));

        player.setColonies(new ArrayList<>());

        player.getColonies().add(homeworld.getColony());

        player.setHomeworld(homeworld);

        //TODO create initial colony

        game.setPlayer(player);

        game.setAiPlayers(new ArrayList<>());

        Faction ai = new Faction();

        ai.setName("Ai");
        ai.setKnowledge(KnowledgeGenerator.startKnowledge());




        game.getAiPlayers().add(ai);

        return game;
    }

    private void generateStars(Universe universe, GameParameters parameters) {
        List<Star> stars = new ArrayList<>();

        for (int i = 1; i <= parameters.getStarCount(); i ++) {
            Star s = new Star();
            s.setIdentifier("S" + i);
            s.setCoordinates(new Coordinates(Math.random() * universe.getSize(), Math.random() * universe.getSize()));

            BigDecimal mass = StarGenerator.generateMass();

            Long temperature = StarGenerator.generateTemperature(mass);

            s.setTemperature(temperature);
            s.setMass(mass.toBigInteger());

            generatePlanets(s, parameters);

            stars.add(s);
        }

        for (Star s : stars) {
            universe.getStars().put(s.getIdentifier(), s);
        }
    }

    private void generatePlanets(Star s, GameParameters parameters) {
        long planetCount = parameters.getMinPlanetsPerStar() + Math.round(Math.random() * parameters.getMaxPlanetsPerStar());

        s.setPlanets(IntStream.rangeClosed(1, (int) planetCount).boxed().map(new Function<Integer, Planet>() {
            @Override
            public Planet apply(Integer integer) {
                Planet p = new Planet(s);

                //TODO special logic for gas giants

                p.setMass(PlanetGenerator.generateMass(random.nextGaussian()));
                p.setIdentifier(s.getIdentifier() + "P" + integer);

                return p;
            }
        }).collect(Collectors.toList()));
    }
}
