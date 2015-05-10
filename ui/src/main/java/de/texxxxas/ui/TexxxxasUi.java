package de.texxxxas.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.generator.TexxxxasGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class TexxxxasUi {
    private TexxxxasGame game;
    private final JFrame mainFrame;

    public TexxxxasUi() {
        mainFrame = new JFrame("TeXXXXas");

        //Build main game window

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mainMenu = new JMenuBar();

        buildMainMenu(mainMenu);
        buildViewMenu(mainMenu);

        mainFrame.setJMenuBar(mainMenu);

        mainFrame.setSize(1200, 800);

        mainFrame.pack();
        mainFrame.setVisible(true);

        //build map window
    }

    private void buildMainMenu(final JMenuBar mainMenu) {
        JMenu gameMenu;
        mainMenu.add(gameMenu = new JMenu("Game"));

        gameMenu.add(new JMenuItem(new AbstractAction("New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                TexxxxasGenerator generator = new TexxxxasGenerator();
                game = generator.generateGame();

                repaintMainFrame();
            }
        }));

        gameMenu.add(new JMenuItem(new AbstractAction("Save Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
                repaintMainFrame();
            }
        }));

        gameMenu.addSeparator();

        gameMenu.add(new AbstractAction("Quit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });


    }

    private void buildViewMenu(final JMenuBar mainMenu) {
        JMenu gameMenu;
        mainMenu.add(gameMenu = new JMenu("View"));

        gameMenu.add(new JMenuItem(new AbstractAction("New Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                TexxxxasGenerator generator = new TexxxxasGenerator();
                game = generator.generateGame();

                repaintMainFrame();
            }
        }));

        gameMenu.add(new JMenuItem(new AbstractAction("Save Game") {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
                repaintMainFrame();
            }
        }));

        gameMenu.addSeparator();

        gameMenu.add(new AbstractAction("Quit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }

    private void saveGame() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true); //pretty output
        try {
            mapper.writeValue(new File(System.getProperty("user.dir") + "\\game.json"), game);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void repaintMainFrame() {
        mainFrame.repaint();
    }
}
