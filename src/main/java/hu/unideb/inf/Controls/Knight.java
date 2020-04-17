/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.Controls;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Muhammad Hassan Raza
 */

@Getter
@Setter
public class Knight extends Label {
    private boolean isWhite;
    private int row;
    private int col;

    public static final int totalRows = 8; 
public static final int totalCols = 8; 
    private static Set<Point> RestrictedSquares = new HashSet<>();

    
    public Knight(boolean isWhite, int row, int col) {
        super("\u2658");
        this.isWhite = isWhite;
        super.setFont(new Font(80));
        this.row = row;
        this.col = col;
        if (!isWhite){
           // super.setTextFill(Color.web("#b58c5c"));
            super.setText("\u265E");
        }
        else{
           // super.setTextFill(Color.web("#F5F5F5"));
        }
    }
    
    public Set<Point> getMoves(){
        Set<Point> possibleMoves = new HashSet<>();
        // All possible moves of a knight 
        int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
        int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; 
        
        // Check if each possible move is valid or not 
        for (int i = 0; i < 8; i++) { 
  
            // Position of knight after move 
            int x = this.row + X[i]; 
            int y = this.col + Y[i]; 
  
            // count valid moves 
            if (x >= 0 && y >= 0 && x < totalRows && y < totalCols 
                && !RestrictedSquares.contains(new Point(x,y))){
                possibleMoves.add(new Point(x, y));
            } 
                 
        } 
        return possibleMoves;
    }
    
    public static void AddRestricted(Point p){
        RestrictedSquares.add(p);
    }
    public Point getCurrentLocation(){
        return new Point(row, col);
    }
    
    
    
    
}
