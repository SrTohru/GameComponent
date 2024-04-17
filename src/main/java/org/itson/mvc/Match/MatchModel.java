/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.Match;

import org.itson.domaincomponent.domain.Board;
import org.itson.domaincomponent.domain.Match;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.domain.Pool;

public class MatchModel {

    private Match match;

    private Board board;

    private Pool pool;

    private Player[] players;

    public MatchModel() {
    }

    public MatchModel(Match match, Board board, Pool pool, Player[] players) {
        this.match = match;
        this.board = board;
        this.pool = pool;
        this.players = players;
        
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player N." + i);
        }
    }

    public Match getMatch() {
        return match;
    }

    public Board getBoard() {
        return board;
    }

    public Pool getPool() {
        return pool;
    }

    public Player[] getPlayers() {
        return players;
    }

    
    public int getListOfTilesSize(){
        return this.getPool().getTiles().size();
    }
    
    
    public void printPlayersTiles(){
        for (int i = 0; i < this.players.length; i++) {
            System.out.println("Player: " + this.players[i].getName());
            for (int j = 0; j <  this.players[i].getTiles().size(); j++) {
                System.out.println("Tile id: " +  this.players[i].getTiles().get(j).getId() + " Value 1: " + this.players[i].getTiles().get(j).getFirstFace().getValue() + " Value 2: " + this.players[i].getTiles().get(j).getSecondFace().getValue());
            }
        }
    }
    
      public void buildGame() {
          
           
            //Generamos jugadores para probar
            for (int i = 0; i < 4; i++) {
                if (this.players[i] == null) {
                    this.players[i] = new Player("Player N. " + i);
                    
                }
            }
            
            
            this.board = Board.getInstance();
            this.pool = Pool.getInstance();
            this.match = new Match(players, board, pool, 3);
            

    
        
    }

}
