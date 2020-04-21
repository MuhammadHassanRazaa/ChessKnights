/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.Model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.Label;
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

    public static final int TOTAL_ROWS = 8;
    public static final int TOTAL_COLS = 8;

    private boolean isWhite;
    private int row;
    private int col;
    private static Set<Point> restrictedSquares = new HashSet<>();

    public Knight(boolean isWhite, int row, int col) {
        super("\u2658");
        this.isWhite = isWhite;
        super.setFont(new Font(80));
        this.row = row;
        this.col = col;
        if (!isWhite) {

            super.setText("\u265E");
        }
    }

    public static void AddRestricted(Point p) {
        restrictedSquares.add(p);
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
                    && !restrictedSquares.contains(new Point(x, y))) {
                possibleMoves.add(new Point(x, y));
            }

        }
        return possibleMoves;
    }

}
