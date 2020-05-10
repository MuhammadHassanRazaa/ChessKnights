/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model.state;

import hu.unideb.inf.model.Player;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ssht
 */
@Setter
@Getter
@NoArgsConstructor
public class GameState {

   public GameState(Player player, Player player0) {
        players = new ArrayList<>();
        this.players.add(player);
        this.players.add(player0);
        this.numPLayer = 2;
        this.turnPlayer = 0;
        isWhiteMove = true;

        players.forEach((player1) -> {
            if (player1.isWhite()) {
                player1.setCol(7);
                player1.setRow(7);
            } else {
                player1.setCol(0);
                player1.setRow(0);
            }
        });
    }

    
    public void advanceTurnPlayer() {

        if (turnPlayer + 1 < numPLayer) {
            turnPlayer++;
        } else {
            turnPlayer = 0;
        }
    }

    private List<Player> players;

    private int numPLayer = 2;

    private int turnPlayer = 0;

    private boolean isWhiteMove;

    public static final int TOTAL_ROWS = 8;
    public static final int TOTAL_COLS = 8;

    @Setter(AccessLevel.NONE)
    @Getter
    private static Set<Point> restrictedSquares = new HashSet<>();

    public Player getOther(int i) {
        if (i == 1) {
            return getPlayer(0);
        } else {
            return getPlayer(i);
        }
    }

    public Player getPlayer(int i) {
        return this.players.get(i);
    }

    public Player getWhitePlayer() {
        return getPlayer(1);
    }

    public Player getBlackPlayer() {
        return getPlayer(0);
    }

    
    public static void AddRestricted(Point p) {
        restrictedSquares.add(p);
    }


}
