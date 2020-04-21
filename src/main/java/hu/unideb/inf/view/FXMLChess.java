/**
 * Sample Skeleton for 'chess.fxml' Controller Class
 */
package hu.unideb.inf.view;

import hu.unideb.inf.Model.Knight;
import java.awt.Point;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FXMLChess {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chessBoardView"
    private GridPane chessBoardView; // Value injected by FXMLLoader

    @FXML // fx:id="pane00"
    private Pane pane00; // Value injected by FXMLLoader

    @FXML
    private Label tunLabel;

    private Knight blackKnight;
    private Knight whiteKnight;
    private Knight clickedKnight;
    private boolean isWhiteMove;
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

            availablePanesToMove.forEach((pane) -> resetColors(row_index, col_index, pane));
            GridPane.setConstraints(clickedKnight, col_index, row_index);
            clickedKnight.setRow(row_index);
            clickedKnight.setCol(col_index);
            availablePanesToMove = FXCollections.observableArrayList();
            Knight.AddRestricted(clickedKnight.getCurrentLocation());
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
        whiteKnight = new Knight(true, 7, 7);
        blackKnight = new Knight(false, 0, 0);

        chessBoardView.add(whiteKnight, whiteKnight.getCol(), whiteKnight.getRow());
        chessBoardView.add(blackKnight, blackKnight.getCol(), blackKnight.getRow());

        Knight.AddRestricted(whiteKnight.getCurrentLocation());
        Knight.AddRestricted(blackKnight.getCurrentLocation());

        whiteKnight.setOnMouseClicked(null);
        blackKnight.setOnMouseClicked(this::knigthOnMouseClicked);
        tunLabel.setText("black");
        isWhiteMove = true;

    }

    private void setPaneClickEvent() {
        if (isWhiteMove) {
            blackKnight.setOnMouseClicked(null);
            whiteKnight.setOnMouseClicked(this::knigthOnMouseClicked);
            tunLabel.setText("white");

            isWhiteMove = false;

        } else {
            whiteKnight.setOnMouseClicked(null);
            blackKnight.setOnMouseClicked(this::knigthOnMouseClicked);
            tunLabel.setText("black");

            isWhiteMove = true;

        }

    }

    private void knigthOnMouseClicked(MouseEvent e) {

        clickedKnight = (Knight) e.getSource();

        Object[] moves = clickedKnight.getMoves().toArray();
        if (moves.length == 0) {
            if (clickedKnight.equals(whiteKnight)) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Black Won", ButtonType.OK);
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "White Won", ButtonType.OK);
                a.showAndWait();
            }
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

}
