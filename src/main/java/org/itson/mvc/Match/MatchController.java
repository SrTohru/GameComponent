/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.Match;

import org.itson.domaincomponent.domain.Player;

/**
 *
 * @author PC
 */
public class MatchController {
    
    
     private MatchModel matchModel;
    private MatchView matchView;

    public MatchController(MatchModel matchModel, MatchView matchView) {
        this.matchModel = matchModel;
        this.matchView = matchView;
    }
    
    
    public Player[] getPlayersOnGame(){
        return this.matchModel.getPlayers();
    }
    
    public void buildGame(){
        this.matchModel.buildGame();  
        this.matchModel.printPlayersTiles();
    }
  
    
    
    
}
