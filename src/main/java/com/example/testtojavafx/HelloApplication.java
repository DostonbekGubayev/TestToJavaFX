package com.example.testtojavafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        ToggleButton tb1=new ToggleButton("Muhim emas");
        ToggleButton tb2=new ToggleButton("O'rtacha");
        ToggleButton tb3=new ToggleButton("O'ta Muhim");
        tb2.setTranslateX(100);
        tb3.setTranslateX(190);
        ToggleGroup group=new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb3.setToggleGroup(group);
        tb1.setUserData(Color.GRAY);
        tb2.setUserData(Color.BLACK);
        tb3.setUserData(Color.CYAN);
        Rectangle rectangle=new Rectangle(100,180, Color.WHITE);
        rectangle.setTranslateY(60);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (t1 == null) {
                    rectangle.setFill(null);
                }else {
                rectangle.setFill((Color) group.getSelectedToggle().getUserData());
                    ;
                }
            }
        });
        StackPane pane=new StackPane(tb1,tb2,tb3,rectangle);
        pane.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(pane, 320, 290);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}