package de.texxxxas.ui.panel;

import de.texxxxas.common.faction.Colony;
import de.texxxxas.ui.panel.colony.ColonyConstructionTab;
import de.texxxxas.ui.panel.colony.ColonyDetailsTab;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ColonyTabsPanel extends JPanel {
    private final JLabel label;
    private Colony selectedColony;

    public ColonyTabsPanel(Colony colony) {
        this.selectedColony = colony;

        JTabbedPane tabbedPane = new JTabbedPane();

        add(label = new JLabel(colony != null ? colony.toString() : "nullcolony " + Math.random()));

        tabbedPane.setPreferredSize(new Dimension(1000, 1000));

        tabbedPane.addTab("Summary", new ColonyDetailsTab(selectedColony));
        tabbedPane.addTab("Construction", new ColonyConstructionTab(selectedColony));

        add(tabbedPane);
    }

    public void repaint(Colony selectedColony) {
        super.repaint();
        setSelectedColony(selectedColony);
    }

    private void setSelectedColony(Colony selectedColony) {
        this.selectedColony = selectedColony;
        label.setText(new Date().toString());
    }
}
