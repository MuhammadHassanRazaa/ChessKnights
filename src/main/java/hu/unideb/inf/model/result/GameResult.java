/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model.result;

import java.io.Serializable;
import java.time.Duration;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author ssht
 */
@Entity
@Data
@Builder
public class GameResult implements Serializable {

    @Id
    private String playerName; 
    
    @Column(nullable=false)
    private boolean win; 
    
    @Column(nullable=false)
    private int winCount;
    
    @Column(nullable=false)
    private ZonedDateTime created;

  
    
    @PrePersist
    protected void onPersist() {
        created = ZonedDateTime.now();
    }
    
}
