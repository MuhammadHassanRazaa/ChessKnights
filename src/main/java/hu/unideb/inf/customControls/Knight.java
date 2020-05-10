/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.customControls;


import javafx.scene.control.Label;
import javafx.scene.text.Font;
import lombok.AccessLevel;
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
    

    private int knightId;


    public Knight(boolean isWhite,int id) {
        super("\u2658");
        this.knightId=id;
        this.isWhite = isWhite;
        super.setFont(new Font(80));
        if (!isWhite) {
            super.setText("\u265E");
        }
    }

   
}
