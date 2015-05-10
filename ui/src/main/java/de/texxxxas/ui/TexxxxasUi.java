package de.texxxxas.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.generator.TexxxxasGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class TexxxxasUi {
    private TexxxxasGame game;
    private JFrame mainFrame;

    public void start() {
        //Build main game window

        mainFrame = new JFrame("TeXXXXas");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildMainMenu(mainFrame);

        mainFrame.setSize(1200, 800);

        mainFrame.pack();
        mainFrame.setVisible(true);

        //build map window
    }

    private void buildMainMenu(JFrame mainFrame) {
        JMenuBar mainMenu = new JMenuBar();

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
                ObjectMapper mapper = new ObjectMapper();

                mapper.configure(SerializationFeature.INDENT_OUTPUT, true); //pretty output
                try {
                    mapper.writeValue(new File(System.getProperty("user.dir") + "\\game.json"), game);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                repaintMainFrame();
            }
        }));

        mainFrame.setJMenuBar(mainMenu);
    }

    private void repaintMainFrame() {
        mainFrame.repaint();
    }
}
