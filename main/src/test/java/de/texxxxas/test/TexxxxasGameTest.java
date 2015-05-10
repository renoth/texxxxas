package de.texxxxas.test;

import de.texxxxas.common.TexxxxasGame;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TexxxxasGameTest extends BaseTest {
    @Test
    public void testTexxxxasGame() {
        TexxxxasGame game = new TexxxxasGame();
        Date date;
        game.setStarDate(date = new Date());

        assertThat(game.getStarDate(), equalTo(date));
    }
}
