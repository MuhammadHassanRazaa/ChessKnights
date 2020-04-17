/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 *
 * @author girgi
 */
public class MainProjectController {

    private static MessageDigest md;

   public static String cryptWithMD5(String pass){
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
    }
        return null;


   }
   
    static boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static void About() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("About Cinepax");
        alert.setContentText("Cinepx is good");
        alert.show();
    }

    public static EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        if (!ButtonType.YES.equals(alert.showAndWait().get())) {
            event.consume();
        }
    };
    
  
}
