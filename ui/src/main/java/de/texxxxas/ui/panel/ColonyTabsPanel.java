package de.texxxxas.ui.panel;

import de.texxxxas.common.faction.Colony;
import de.texxxxas.ui.panel.colony.ColonyConstructionTab;
import de.texxxxas.ui.panel.colony.ColonyDetailsTab;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ColonyTabsPanel extends JPanel {
    private final ColonyDetailsTab detailsTab;

    private Colony selectedColony;

    public ColonyTabsPanel(Colony colony) {
        this.selectedColony = colony;

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.setPreferredSize(new Dimension(500, 500));

        tabbedPane.addTab("Summary", detailsTab = new ColonyDetailsTab(selectedColony));
        tabbedPane.addTab("Construction", new ColonyConstructionTab(selectedColony));

        add(tabbedPane, BorderLayout.CENTER);
    }

    public void repaint(Colony selectedColony) {
        super.repaint();
        if (selectedColony != null) {
            setSelectedColony(selectedColony);

            detailsTab.repaint(selectedColony);
        }
    }

    private void setSelectedColony(Colony selectedColony) {
        this.selectedColony = selectedColony;
    }
}
