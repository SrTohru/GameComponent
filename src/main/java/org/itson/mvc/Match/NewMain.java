/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.mvc.Match;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.exceptions.PoolException;
import org.itson.game.MatchGame;
import org.itson.game.TurnManager;

/**
 *
 * @author PC
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchGame mtc = new MatchGame(new Player("Test Player"));
        
        try {
            mtc.buildGame();
            // mtc.suscribeToPoolView();
        } catch (PoolException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
              TurnManager trn = new TurnManager();
        
        trn.generateTurns(mtc.getPlayersOnGame());
        
        trn.printTurns();
        
       
      // mtc.getPoolView().simulatePanelClick();
        
    }
    
}
