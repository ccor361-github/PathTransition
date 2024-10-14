package es.ieslosmontecillos.pathtransition;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransition extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();


        Circle circle = new Circle(200, 200, 100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        root.getChildren().add(circle);

        Rectangle rect = new Rectangle(100, 50);
        rect.setId("moving-rect");
        root.getChildren().add(rect);

        javafx.animation.PathTransition pathTransition = new javafx.animation.PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(circle);
        pathTransition.setNode(rect);
        pathTransition.setCycleCount(javafx.animation.PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(false);

        pathTransition.play();

        circle.setOnMousePressed((MouseEvent event) -> {
            pathTransition.pause();
        });

        circle.setOnMouseReleased((MouseEvent event) -> {
            pathTransition.play();
        });

        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("PathTransition Animation with CSS Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
