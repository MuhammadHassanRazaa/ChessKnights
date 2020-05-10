/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import hu.unideb.inf.model.state.GameState;
import static hu.unideb.inf.model.state.GameState.TOTAL_COLS;
import static hu.unideb.inf.model.state.GameState.TOTAL_ROWS;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ssht
 */
@Setter
@Getter
@ToString
public class Player {
    private String name;
     private int row;
    private int col;    
    private boolean isWhite;
    private int playerId;


    public Player(String user1,boolean isWhite,int id) {
        this.name = user1;
        this.isWhite = isWhite;
        this.playerId = id;
        
    }
    
    public Point getCurrentLocation() {
        return new Point(row, col);
    }
    
        public Set<Point> getMoves() {
        Set<Point> possibleMoves = new HashSet<>();
        // All possible moves of a knight
        int X[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int Y[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Check if each possible move is valid or not
        for (int i = 0; i < 8; i++) {

            // Position of knight after move
            int x = this.row + X[i];
            int y = this.col + Y[i];

            // count valid moves
            if (x >= 0 && y >= 0 && x < TOTAL_ROWS && y < TOTAL_COLS
                    && !GameState.getRestrictedSquares().contains(new Point(x, y))) {
                possibleMoves.add(new Point(x, y));
            }

        }
        return possibleMoves;
    }
}
