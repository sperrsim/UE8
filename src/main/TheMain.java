package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Starts the Application
 * @author Simon Sperr
 * @version 2020.1.1, 22.11.2020
 */
public class TheMain extends Application {
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/controllerView/currencyConverterV.fxml"));
    primaryStage.setTitle("Currency Converter");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }
  
  
  public static void main(String[] args) {
    launch(args);
  }
}
