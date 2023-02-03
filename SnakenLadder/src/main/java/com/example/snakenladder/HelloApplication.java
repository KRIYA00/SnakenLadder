package com.example.snakenladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
   public static Group root;
    @Override

    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
       //Parent root=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        root=new Group();
        stage.setTitle("Snake and Ladder");
        GamePage page=new GamePage();
        root.getChildren().add(page.root);
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}