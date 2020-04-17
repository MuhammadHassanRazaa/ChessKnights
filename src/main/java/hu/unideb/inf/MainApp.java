package hu.unideb.inf;

import hu.unideb.inf.view.*;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.WindowEvent;


public class MainApp extends Application {

    
    public static Connection  ConnectToDb() throws SQLException {
        Connection conn = null;
      try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:CinemaMS.db";
            File file = new File("cinemaMS.db");
            System.out.println(file.getAbsoluteFile());
             conn= DriverManager.getConnection(dbURL);
            
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }  
      return conn;
       
    }
private Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/chess.fxml"));
        Scene scene = new Scene(loader.load());
    this.mainStage = stage;
        stage.setTitle("Main Chess");
       
        stage.setOnCloseRequest(MainProjectController.confirmCloseEventHandler);
        stage.setScene(scene);
        stage.show();
    }
    
    

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        
        //ConnectToDb();
        launch(args);
    }

}
