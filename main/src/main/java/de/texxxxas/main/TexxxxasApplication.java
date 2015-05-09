package de.texxxxas.main;

import de.texxxxas.generator.TexxxxasGenerator;
import de.texxxxas.ui.TexxxxasUi;

public class TexxxxasApplication {
    public static void main(String[] args) {
        System.out.println("Starting Application ... ");

        TexxxxasGenerator generator = new TexxxxasGenerator();
        generator.start();

        TexxxxasUi ui = new TexxxxasUi();
        ui.start();
    }
}
