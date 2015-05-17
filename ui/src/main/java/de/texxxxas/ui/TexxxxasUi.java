package de.texxxxas.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.texxxxas.common.TexxxxasGame;
import de.texxxxas.common.universe.Universe;
import de.texxxxas.generator.TexxxxasGenerator;
import de.texxxxas.ui.panel.EmpirePanel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class TexxxxasUi {
    public static final int MAP_SIZE_PX = 1000;

    private final MapPanelJFX mapPanel;
    private final EmpirePanel empirePanel;

    private TexxxxasGame game;

    private final JFrame mainFrame;

    public TexxxxasUi() {
        game = new TexxxxasGame();
        game.setUniverse(new Universe());

        mainFrame = new JFrame("TeXXXXas");

        //Build main game window

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar mainMenu = new JMenuBar();

        buildGameMenu(mainMenu);
        buildViewMenu(mainMenu);

        mainFrame.setJMenuBar(mainMenu);



        mainFrame.pack();
        mainFrame.setVisible(true);

        //TODO build map window

        JTabbedPane tabbedPane = new JTabbedPane();

        //add javaFX pane

        mapPanel = new MapPanelJFX(this);
        //mapPanel.setSize(MAP_SIZE_PX, MAP_SIZE_PX);

        //mainFrame.add(mapPanel);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initScene(mapPanel);
            }
        });

        tabbedPane.addTab("Map", mapPanel);
        tabbedPane.addTab("Empire", empirePanel = new EmpirePanel(this));

        mainFrame.setSize(1400, 1000);
        mainFrame.add(tabbedPane);
    }

    private void initScene(JFXPanel fxPanel) {
        Scene scene = mapPanel.createScene();
        fxPanel.setScene(scene);
    }

    private void buildGameMenu(final JMenuBar mainMenu) {
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initScene(mapPanel);
                mapPanel.drawContent();
            }
        });

    }

    public TexxxxasGame getGame() {
        return game;
    }
}
