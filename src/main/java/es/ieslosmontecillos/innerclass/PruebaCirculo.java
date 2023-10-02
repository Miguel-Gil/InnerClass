package es.ieslosmontecillos.innerclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.circle;


/**
 *
 * @author Miguel
 */
public class PruebaCirculo extends Application {

    Circle circle = new Circle();
    @Override
    public void start(Stage primaryStage) {

        // create a HBox
        HBox hbox = new HBox();
        StackPane pane = new StackPane();
        BorderPane borderpane = new BorderPane();
        // Creando un círculo y activando sus propiedades

        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // set title for the stage
        primaryStage.setTitle("Circulo");

        borderpane.setPadding(new Insets(15,15,15,15));

        Button btn = new Button();
        btn.setText("Agrandar");
        btn.setOnAction(new AgrandarClass()

            /**@Override
            public void handle(ActionEvent event) {
                double radio = circle.getRadius();
                radio = radio + 5;
                circle.setRadius(radio);
            }**/
        );

        Button btn2 = new Button();
        btn2.setText("Empequeñecer");
        btn2.setOnAction(new EmpequenecerClass()

            /**@Override
            public void handle(ActionEvent event) {
                double radio = circle.getRadius();
                radio = radio - 5;
                circle.setRadius(radio);
            }**/
        );
        hbox.getChildren().addAll(btn,btn2);
        pane.getChildren().addAll(circle,borderpane);
        borderpane.setBottom(hbox);
        hbox.setAlignment(Pos.CENTER);
        // create a scene
        Scene scene = new Scene(pane, 300, 300);

        // set the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class AgrandarClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            agrandarciculo();
        }
    }

    class EmpequenecerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            empequenecer();
        }
    }

    public void agrandarciculo() {
        double radio = circle.getRadius();
        radio = radio + 5;
        circle.setRadius(radio);
    }

    public void empequenecer() {
        double radio = circle.getRadius();
        radio = radio - 5;
        circle.setRadius(radio);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}