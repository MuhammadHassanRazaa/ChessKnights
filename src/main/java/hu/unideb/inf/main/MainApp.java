package hu.unideb.inf.main;

import hu.unideb.inf.FunctionsLibrary.FunctionsLib;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author ssht
 */
@Slf4j
public class MainApp extends Application {

    private Stage mainStage;

    /**
     * <p>
     * This Method will launch the Main Scene of the Game and will set the
     * attributes.</p>
     *
     *
     * @param stage the main stage
     * @throws Exception throws Exception if there's any Loading Error
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/fxml/MainScene.fxml"));
        Scene scene = new Scene(loader.load());
        this.mainStage = stage;
        stage.setTitle("Chess Knights");
        stage.setResizable(false);
        stage.setOnCloseRequest(FunctionsLib.confirmCloseEventHandler);
        stage.setScene(scene);
        stage.show();
        log.info("Showing the Main Scene of Game");
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

}
