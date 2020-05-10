/**
 * Sample Skeleton for 'chess.fxml' Controller Class
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.customControls.Knight;
import hu.unideb.inf.model.state.GameState;
import hu.unideb.inf.model.Player;
import hu.unideb.inf.model.result.GameResult;
import hu.unideb.inf.model.result.GameResultDao;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class FXMLChess {
    GameState gameState = new GameState();
    GameResultDao gameResultDAO ;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chessBoardView"
    private GridPane chessBoardView; // Value injected by FXMLLoader

    

    @FXML
    private Label tunLabel;

    private Knight blackKnight;
    private Knight whiteKnight;
    private Knight clickedKnight;
   
    private boolean isWhiteLastMove = false;
    private boolean isBlackLastMove = false;
    private int lastMoveCount = 0;
    private Point knightPreviousLocation = new Point();
    private ObservableList<Pane> availablePanesToMove = FXCollections.observableArrayList();


    @FXML
    void paneMouseClicked(MouseEvent event) {
        if (availablePanesToMove.contains((Pane) event.getSource()) && event.getSource() instanceof Pane) {
            int row_index = (GridPane.getRowIndex((Node) event.getSource()) == null) ? 0 : GridPane.getRowIndex((Node) event.getSource());
            int col_index = (GridPane.getColumnIndex((Node) event.getSource()) == null) ? 0 : GridPane.getColumnIndex((Node) event.getSource());
            knightPreviousLocation = new Point(GridPane.getColumnIndex(clickedKnight) == null ? 0 : GridPane.getColumnIndex(clickedKnight),
                    GridPane.getRowIndex(clickedKnight) == null ? 0 : GridPane.getRowIndex(clickedKnight));

            ObservableList<Node> childrens = chessBoardView.getChildren();
            for (Node node : childrens) {
                if ((knightPreviousLocation.x == (GridPane.getColumnIndex(node) == null ? 0 : GridPane.getColumnIndex(node)))
                        && (knightPreviousLocation.y == (GridPane.getRowIndex(node) == null ? 0 : GridPane.getRowIndex(node)))) {

                    if (node instanceof Pane) {
                        ((Pane) node).setStyle("-fx-background-color: #800000");

                    }

                }
            }
            gameState.advanceTurnPlayer();
            availablePanesToMove.forEach((pane) -> resetColors(row_index, col_index, pane));
            GridPane.setConstraints(clickedKnight, col_index, row_index);
            ((Player)gameState.getPlayer(clickedKnight.getKnightId())).setRow(row_index);
            ((Player)gameState.getPlayer(clickedKnight.getKnightId())).setCol(col_index);
            availablePanesToMove = FXCollections.observableArrayList();
            GameState.AddRestricted(((Player)gameState.getPlayer(clickedKnight.getKnightId())).getCurrentLocation());
            setPaneClickEvent();

        }
    }

    private void resetColors(int row_index, int col_index, Pane pane) {
        if (row_index % 2 == 0 && col_index % 2 == 0) {

            pane.setStyle("-fx-background-color: white;");
        } else if (row_index % 2 != 0 && col_index % 2 == 0) {
            pane.setStyle("-fx-background-color: #808080;");
        } else if (row_index % 2 == 0 && col_index % 2 != 0) {
            pane.setStyle("-fx-background-color: #808080;");
        } else {
            pane.setStyle("-fx-background-color: white;");
        }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        whiteKnight = new Knight(true,1);
        blackKnight = new Knight(false,0);

        chessBoardView.add(whiteKnight, gameState.getWhitePlayer().getCol(), gameState.getWhitePlayer().getRow());
        chessBoardView.add(blackKnight, gameState.getBlackPlayer().getCol(), gameState.getBlackPlayer().getRow());

        GameState.AddRestricted(gameState.getWhitePlayer().getCurrentLocation());
        GameState.AddRestricted(gameState.getBlackPlayer().getCurrentLocation());

        whiteKnight.setOnMouseClicked(null);
        blackKnight.setOnMouseClicked(this::knigthOnMouseClicked);
        tunLabel.setText(gameState.getPlayer(gameState.getTurnPlayer()).getName());
    }

    private void setPaneClickEvent() {
        if (gameState.isWhiteMove()) {
            blackKnight.setOnMouseClicked(null);
            whiteKnight.setOnMouseClicked(this::knigthOnMouseClicked);
            tunLabel.setText(gameState.getWhitePlayer().getName());

            

        } else {
            whiteKnight.setOnMouseClicked(null);
            blackKnight.setOnMouseClicked(this::knigthOnMouseClicked);
            tunLabel.setText(gameState.getBlackPlayer().getName());

       

        }
        gameState.setWhiteMove(!gameState.isWhiteMove());

    }

    private void knigthOnMouseClicked(MouseEvent e) {

        clickedKnight = (Knight) e.getSource();

        Object[] moves =((Player)gameState.getPlayer(clickedKnight.getKnightId())).getMoves().toArray();
        if (moves.length == 0) {
          String  playerWonName = gameState.getOther(clickedKnight.getKnightId()).getName();
          Alert a = new Alert(Alert.AlertType.INFORMATION, playerWonName+" Won", ButtonType.OK);
                a.showAndWait();
        }

        for (Object move : moves) {
            ObservableList<Node> childrens = chessBoardView.getChildren();
            for (Node node : childrens) {
                int row_index = (GridPane.getRowIndex(node)) == null ? 0 : GridPane.getRowIndex(node);
                int col_index = (GridPane.getColumnIndex(node)) == null ? 0 : GridPane.getColumnIndex(node);

                if (row_index == ((Point) move).x && col_index == ((Point) move).y) {

                    availablePanesToMove.add((Pane) node);

                    // ((Pane) node).setBackground(Knight.getRestrictedBg());
                    ((Pane) node).setStyle("-fx-background-color: #FFFF00;");

                }
            }
        }

    }

    void initData(String player, String player0) {
        gameState = new GameState(new Player(player,false,0),new Player(player0,true,1));
        gameResultDAO = GameResultDao.getInstance();
    }

    

    private GameResult getResult(String name, boolean t) {
        GameResult result = GameResult.builder()
                                    .playerName(name)
                                    .win(t)
                                    .build();
        return result;
    }

    public void finishGame(ActionEvent actionEvent) throws IOException {
        String  playerWonName = gameState.getOther(clickedKnight.getKnightId()).getName();
        String playerLooseGame = gameState.getPlayer(clickedKnight.getKnightId()).getName();
          Alert a = new Alert(Alert.AlertType.INFORMATION, playerWonName+" Won", ButtonType.OK);
                a.showAndWait();
        
          if(gameResultDAO.checkUserNameExists(playerWonName)){
              gameResultDAO.persist(getResult(playerWonName,true));
          }
          else{
              gameResultDAO.update(getResult(playerWonName, true));
          }
          if(gameResultDAO.checkUserNameExists(playerLooseGame)){
              gameResultDAO.persist(getResult(playerLooseGame,false));
          }
          else{
              gameResultDAO.update(getResult(playerLooseGame,false));
          }
            
            

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/topten.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        log.info("Finished game, loading Top 5 PLayers.");
    }
}
