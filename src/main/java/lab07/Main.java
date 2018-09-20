//Pakapol Sanarge 5810405223

package lab07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("../StartTotalUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainUI.fxml"));
        primaryStage.setTitle("รายรับรายจ่าย");
        //primaryStage.setScene(new Scene(root, 600, 242));
        primaryStage.setScene(new Scene(root, 600, 440));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
