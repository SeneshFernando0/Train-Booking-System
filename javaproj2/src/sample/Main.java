package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;


public class Main extends Application {


//launching the fxml and the controller class

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TRAIN STATION QUEUE");
        primaryStage.setScene(new Scene(root, 1750, 800));
        primaryStage.show();

    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch(args);




    }





}




