package de.texxxxas.ui.panel;

import de.texxxxas.common.universe.Planet;
import de.texxxxas.common.universe.Star;
import de.texxxxas.ui.TexxxxasUi;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class EmpirePanel extends JPanel {

    private final TexxxxasUi texxxxasUi;
    private JTree tree;

    public EmpirePanel(TexxxxasUi texxxxasUi) {
        this.texxxxasUi = texxxxasUi;

        setLayout(new BorderLayout());

        createUniverseTreeView();
    }

    private void createUniverseTreeView() {
        tree = new JTree();
        tree.setModel(new DefaultTreeModel(buildUniverseTree()));

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        TreeSelectionListener tsl = new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node == null) return;

                System.out.println(node.getUserObject());
            }
        };

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(tsl);

        tree.setCellRenderer(new ColonyTreeNodeRenderer());

        tree.putClientProperty("JTree.lineStyle", "Horizontal");

        JScrollPane treeView = new JScrollPane(tree);
        treeView.setPreferredSize(new Dimension(400, 1000));

        add(treeView, BorderLayout.WEST);
    }

    @Override
    public void repaint() {
        super.repaint();

        if (tree != null) {
            tree.setModel(new DefaultTreeModel(buildUniverseTree()));
        }
    }

    private DefaultMutableTreeNode buildUniverseTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Empire");

        if (texxxxasUi != null && texxxxasUi.getGame().getUniverse().getStars() != null) {
            for (Star s : texxxxasUi.getGame().getUniverse().getStars().values()) {
                DefaultMutableTreeNode starNode = new DefaultMutableTreeNode(s);

                for (Planet p : s.getPlanets()) {
                    starNode.add(new DefaultMutableTreeNode(p));
                }

                root.add(starNode);
            }
        }

        return root;
    }
}
