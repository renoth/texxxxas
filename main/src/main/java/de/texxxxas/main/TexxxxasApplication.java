package de.texxxxas.main;

import de.texxxxas.ui.TexxxxasUi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class TexxxxasApplication {
    static Logger log = LoggerFactory.getLogger(TexxxxasApplication.class);

    public static void main(String[] args) {
        log.info("Starting Application ...");

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TexxxxasUi();
            }
        });
    }
}
