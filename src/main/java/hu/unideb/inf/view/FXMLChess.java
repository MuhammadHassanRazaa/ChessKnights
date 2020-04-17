/**
 * Sample Skeleton for 'chess.fxml' Controller Class
 */

package hu.unideb.inf.view;

import hu.unideb.inf.Controls.Knight;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class FXMLChess {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="chessBoardView"
    private GridPane chessBoardView; // Value injected by FXMLLoader

    @FXML // fx:id="pane00"
    private Pane pane00; // Value injected by FXMLLoader

   
    private Knight blackKnight; 

    @FXML // fx:id="pane01"
    private Pane pane01; // Value injected by FXMLLoader

    @FXML // fx:id="pane02"
    private Pane pane02; // Value injected by FXMLLoader

    @FXML // fx:id="pane03"
    private Pane pane03; // Value injected by FXMLLoader

    @FXML // fx:id="pane04"
    private Pane pane04; // Value injected by FXMLLoader

    @FXML // fx:id="pane05"
    private Pane pane05; // Value injected by FXMLLoader

    @FXML // fx:id="pane06"
    private Pane pane06; // Value injected by FXMLLoader

    @FXML // fx:id="pane07"
    private Pane pane07; // Value injected by FXMLLoader

    @FXML // fx:id="pane10"
    private Pane pane10; // Value injected by FXMLLoader

    @FXML // fx:id="pane11"
    private Pane pane11; // Value injected by FXMLLoader

    @FXML // fx:id="pane12"
    private Pane pane12; // Value injected by FXMLLoader

    @FXML // fx:id="pane13"
    private Pane pane13; // Value injected by FXMLLoader

    @FXML // fx:id="pane14"
    private Pane pane14; // Value injected by FXMLLoader

    @FXML // fx:id="pane15"
    private Pane pane15; // Value injected by FXMLLoader

    @FXML // fx:id="pane16"
    private Pane pane16; // Value injected by FXMLLoader

    @FXML // fx:id="pane17"
    private Pane pane17; // Value injected by FXMLLoader

    @FXML // fx:id="pane20"
    private Pane pane20; // Value injected by FXMLLoader

    @FXML // fx:id="pane21"
    private Pane pane21; // Value injected by FXMLLoader

     @FXML
    private Label tunLabel;
     
    @FXML // fx:id="pane22"
    private Pane pane22; // Value injected by FXMLLoader

    @FXML // fx:id="pane23"
    private Pane pane23; // Value injected by FXMLLoader

    @FXML // fx:id="pane24"
    private Pane pane24; // Value injected by FXMLLoader

    @FXML // fx:id="pane25"
    private Pane pane25; // Value injected by FXMLLoader

    @FXML // fx:id="pane26"
    private Pane pane26; // Value injected by FXMLLoader

    @FXML // fx:id="pane27"
    private Pane pane27; // Value injected by FXMLLoader

    @FXML // fx:id="pane30"
    private Pane pane30; // Value injected by FXMLLoader

    @FXML // fx:id="pane31"
    private Pane pane31; // Value injected by FXMLLoader

    @FXML // fx:id="pane32"
    private Pane pane32; // Value injected by FXMLLoader

    @FXML // fx:id="pane33"
    private Pane pane33; // Value injected by FXMLLoader

    @FXML // fx:id="pane34"
    private Pane pane34; // Value injected by FXMLLoader

    @FXML // fx:id="pane35"
    private Pane pane35; // Value injected by FXMLLoader

    @FXML // fx:id="pane36"
    private Pane pane36; // Value injected by FXMLLoader

    @FXML // fx:id="pane37"
    private Pane pane37; // Value injected by FXMLLoader

    @FXML // fx:id="pane40"
    private Pane pane40; // Value injected by FXMLLoader

    @FXML // fx:id="pane41"
    private Pane pane41; // Value injected by FXMLLoader

    @FXML // fx:id="pane42"
    private Pane pane42; // Value injected by FXMLLoader

    @FXML // fx:id="pane43"
    private Pane pane43; // Value injected by FXMLLoader

    @FXML // fx:id="pane44"
    private Pane pane44; // Value injected by FXMLLoader

    @FXML // fx:id="pane45"
    private Pane pane45; // Value injected by FXMLLoader

    @FXML // fx:id="pane46"
    private Pane pane46; // Value injected by FXMLLoader

    @FXML // fx:id="pane47"
    private Pane pane47; // Value injected by FXMLLoader

    @FXML // fx:id="pane50"
    private Pane pane50; // Value injected by FXMLLoader

    @FXML // fx:id="pane51"
    private Pane pane51; // Value injected by FXMLLoader

    @FXML // fx:id="pane52"
    private Pane pane52; // Value injected by FXMLLoader

    @FXML // fx:id="pane53"
    private Pane pane53; // Value injected by FXMLLoader

    @FXML // fx:id="pane54"
    private Pane pane54; // Value injected by FXMLLoader

    @FXML // fx:id="pane55"
    private Pane pane55; // Value injected by FXMLLoader

    @FXML // fx:id="pane56"
    private Pane pane56; // Value injected by FXMLLoader

    @FXML // fx:id="pane57"
    private Pane pane57; // Value injected by FXMLLoader

    @FXML // fx:id="pane60"
    private Pane pane60; // Value injected by FXMLLoader

    @FXML // fx:id="pane61"
    private Pane pane61; // Value injected by FXMLLoader

    @FXML // fx:id="pane62"
    private Pane pane62; // Value injected by FXMLLoader

    @FXML // fx:id="pane63"
    private Pane pane63; // Value injected by FXMLLoader

    @FXML // fx:id="pane64"
    private Pane pane64; // Value injected by FXMLLoader

    @FXML // fx:id="pane65"
    private Pane pane65; // Value injected by FXMLLoader

    @FXML // fx:id="pane66"
    private Pane pane66; // Value injected by FXMLLoader

    @FXML // fx:id="pane67"
    private Pane pane67; // Value injected by FXMLLoader

    @FXML // fx:id="pane70"
    private Pane pane70; // Value injected by FXMLLoader

    @FXML // fx:id="pane71"
    private Pane pane71; // Value injected by FXMLLoader

    @FXML // fx:id="pane72"
    private Pane pane72; // Value injected by FXMLLoader

    @FXML // fx:id="pane73"
    private Pane pane73; // Value injected by FXMLLoader

    @FXML // fx:id="pane74"
    private Pane pane74; // Value injected by FXMLLoader

    @FXML // fx:id="pane75"
    private Pane pane75; // Value injected by FXMLLoader

    @FXML // fx:id="pane76"
    private Pane pane76; // Value injected by FXMLLoader

    @FXML // fx:id="pane77"
    private Pane pane77; // Value injected by FXMLLoader

    private boolean isWhiteMove;
    private Knight whiteKnight; 
    private Knight clickedKnight;
    private boolean isWhiteLastMove=false;
    private boolean isBlackLastMove=false;
    private int lastMoveCount=0;

    private ObservableList<Pane> availablePanestoMove = FXCollections.observableArrayList();
    @FXML
    void PaneMouseClicked(MouseEvent event) {
        if(availablePanestoMove.contains((Pane)event.getSource()) && event.getSource() instanceof Pane){
            int row_index = (GridPane.getRowIndex((Node) event.getSource())==null)?0:GridPane.getRowIndex((Node) event.getSource());
            int col_index = (GridPane.getColumnIndex((Node) event.getSource())==null)?0:GridPane.getColumnIndex((Node) event.getSource());
           
            
            availablePanestoMove.forEach((pane) -> ResetColors(row_index, col_index, pane));
            GridPane.setConstraints(clickedKnight, col_index, row_index);
                clickedKnight.setRow(row_index);
                clickedKnight.setCol(col_index);
                availablePanestoMove = FXCollections.observableArrayList();
                Knight.AddRestricted(clickedKnight.getCurrentLocation());
              SetPaneClickEvent();
                 
              
          
        } 
    }

    private void ResetColors(int row_index, int col_index, Pane pane) {
        if(row_index %2 == 0 && col_index %2 ==0)
            pane.setStyle("-fx-background-color: white;");
        
        else if(row_index %2 !=0 && col_index %2 == 0)
            
            pane.setStyle("-fx-background-color: #808080;");
        else if(row_index %2 ==0 && col_index %2 != 0)
            pane.setStyle("-fx-background-color: #808080;");
        
        else
            pane.setStyle("-fx-background-color: white;");
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        whiteKnight = new Knight(true, 7, 7);
        chessBoardView.add(whiteKnight, whiteKnight.getCol(), whiteKnight.getRow());
        Knight.AddRestricted(whiteKnight.getCurrentLocation());
        blackKnight = new Knight(false, 0, 0);
        chessBoardView.add(blackKnight, blackKnight.getCol(), blackKnight.getRow());
        Knight.AddRestricted(blackKnight.getCurrentLocation());
        System.out.println(whiteKnight.getTextFill().hashCode());
        isWhiteMove=true;
        whiteKnight.setOnMouseClicked(null);
            blackKnight.setOnMouseClicked(this::KnigthOnMouseClicked);
       tunLabel.setText("black");

    }

    private void SetPaneClickEvent() {
        if(isWhiteMove  ){
            blackKnight.setOnMouseClicked(null);
      whiteKnight.setOnMouseClicked(this::KnigthOnMouseClicked);
        tunLabel.setText("white");
        
        
            isWhiteMove=false;
        
                
        }
        else {
            whiteKnight.setOnMouseClicked(null);
            blackKnight.setOnMouseClicked(this::KnigthOnMouseClicked);
        tunLabel.setText("black");
       
       
              isWhiteMove=true;
        
       
        }
       
    }

    private void KnigthOnMouseClicked(MouseEvent e) {
        System.out.println(isWhiteMove);
  
        clickedKnight = (Knight) e.getSource();
        
        Object[] moves =  clickedKnight.getMoves().toArray();
        System.out.println(Arrays.toString(moves));
       if(moves.length==0){
           if(clickedKnight.equals(whiteKnight)){
               Alert a = new Alert(Alert.AlertType.INFORMATION, "Black Won", ButtonType.OK);
               a.showAndWait();
           }else{
               Alert a = new Alert(Alert.AlertType.INFORMATION, "White Won", ButtonType.OK);
               a.showAndWait();
           }
       }
       
       
        for (Object move : moves) {
            ObservableList<Node> childrens = chessBoardView.getChildren();
            for (Node node : childrens) {
                int row_index = (GridPane.getRowIndex(node))==null ? 0 : GridPane.getRowIndex(node);
                int col_index = (GridPane.getColumnIndex(node))==null ? 0 : GridPane.getColumnIndex(node);

                if(row_index == ((Point)move).x && col_index == ((Point)move).y) {
 
                      availablePanestoMove.add((Pane)node);
                     
                     ((Pane) node).setStyle("-fx-background-color: #FFFF00;");
                     
                     
                 
                }
            }
        }
        

}

    private void DisableWholeChess() {
        chessBoardView.getChildren().forEach((node) -> {
            node.setDisable(true);
        });
    }
    
        

   
    
}
