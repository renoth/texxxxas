package de.texxxxas.ui;

import de.texxxxas.common.universe.Star;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MapPanelJFX extends JFXPanel {
    private final TexxxxasUi texxxxasUi;
    private Group root;

    private double pxPerLy;

    public MapPanelJFX(TexxxxasUi texxxxasUi) {
        this.texxxxasUi = texxxxasUi;
    }

    protected Scene createScene() {
        root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);



        return scene;
    }

    public void drawContent() {
        if (texxxxasUi != null && texxxxasUi.getGame().getUniverse() != null) {
            pxPerLy = texxxxasUi.MAP_SIZE_PX / texxxxasUi.getGame().getUniverse().getSize();
        }

        Text text = new Text();

        text.setX(10);
        text.setY(10);
        text.setFont(new Font(10));

        if (texxxxasUi.getGame() != null) {
            text.setText(texxxxasUi.getGame().getUniverse().getStars().size() + " Stars");
        }

        root.getChildren().addAll(text);

        Paint paint = Color.DARKGREY;

        EventHandler filter = new EventHandler<InputEvent> () {
            public void handle(InputEvent event) {
                System.out.println("Klick on star");
                event.consume();
            }
        };

        for (Star star : texxxxasUi.getGame().getUniverse().getStars().values()) {
            Circle c = new Circle(star.getCoordinates().getLyX() * pxPerLy, star.getCoordinates().getLyY() * pxPerLy, 10 ,paint);

            Tooltip.install(c, new Tooltip(star.toString()));

            c.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);

            root.getChildren().add(c);
        }
    }
}
