/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.classes;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import org.itson.domaincomponent.domain.Match;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.domain.Pool;
import org.itson.domaincomponent.domain.Tile;
import org.itson.domaincomponent.exceptions.MatchException;
import org.itson.domaincomponent.exceptions.PoolException;


public class Lobby {
    
    private Match match ;

    public void dealTiles(Player[] players) throws PoolException, MatchException{
        match.setPlayers(players);
        match.setPool(Pool.getInstance());
        match.distributeTiles();
    }
    
    public ArrayList<Player> getPlayersData(){
        
        return null;
    }
}
