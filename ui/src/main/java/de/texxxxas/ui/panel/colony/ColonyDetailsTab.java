package de.texxxxas.ui.panel.colony;

import de.texxxxas.common.faction.Colony;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ColonyDetailsTab extends JPanel {
    private Colony selectedColony;
    private final JLabel populationLabel;

    public ColonyDetailsTab(Colony selectedColony) {
        this.selectedColony = selectedColony;

        populationLabel = new JLabel("");

        add(populationLabel, BorderLayout.NORTH);
    }

    public void repaint(Colony colony) {
        super.repaint();

        selectedColony = colony;

        if (selectedColony != null) {
            populationLabel.setText(selectedColony.getPopulation() + new Date().toString());
        }
    }
}
