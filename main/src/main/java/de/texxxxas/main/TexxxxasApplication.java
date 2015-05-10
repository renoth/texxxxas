package de.texxxxas.main;

import de.texxxxas.ui.TexxxxasUi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TexxxxasApplication {
    static Logger log = LoggerFactory.getLogger(TexxxxasApplication.class);

    public static void main(String[] args) {
        log.info("Starting Application ...");

        new TexxxxasUi();
    }
}
