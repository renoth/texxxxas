package de.texxxxas.ui.panel;

import de.texxxxas.common.universe.CelestialBody;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class ColonyTreeNodeRenderer implements TreeCellRenderer {
    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();


    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        if (value instanceof DefaultMutableTreeNode && ((DefaultMutableTreeNode) value).getUserObject() instanceof CelestialBody) {
            System.out.println(value);
            CelestialBody cb = (CelestialBody) ((DefaultMutableTreeNode) value).getUserObject();
            JPanel panel = new JPanel();
            panel.add(new JLabel(cb.getIdentifier()));
            //panel.add(new JLabel("TEST"));
            return panel;
        } else {
            return defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        }
    }
}
