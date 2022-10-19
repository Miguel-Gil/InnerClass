/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pruebacirculo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.*;
import javafx.scene.web.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import static jdk.nashorn.internal.runtime.regexp.joni.constants.StackType.POS;

/**
 *
 * @author Miguel
 */
public class PruebaCirculo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
   
        // create a VBox
        //VBox vbox = new VBox();
        HBox hbox = new HBox();
        StackPane pane = new StackPane();
        BorderPane borderpane = new BorderPane();
        // Creando un círculo y activando sus propiedades
        Circle circle = new Circle();
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
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                double radio = circle.getRadius();
                radio = radio + 5;
                circle.setRadius(radio);
            }
            });
        
        Button btn2 = new Button();
        btn2.setText("Empequeñecer");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                double radio = circle.getRadius();
                radio = radio - 5;
                circle.setRadius(radio);
            }
            });
        hbox.getChildren().addAll(btn,btn2);
        //vbox.getChildren().addAll(circle,hbox);
        pane.getChildren().addAll(circle,borderpane);
        borderpane.setBottom(hbox);
        hbox.setAlignment(Pos.CENTER);
        //vbox.setAlignment(Pos.CENTER);
        // create a scene
        Scene scene = new Scene(pane, 300, 300);
  
        // set the scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
