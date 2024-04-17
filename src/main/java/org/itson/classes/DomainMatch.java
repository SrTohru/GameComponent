  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.classes;

import java.awt.List;
import java.util.LinkedList;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.domain.Pool;
import org.itson.domaincomponent.domain.Tile;
import org.itson.domaincomponent.exceptions.PlayerException;
import org.itson.domaincomponent.exceptions.PoolException;

/**
 *
 * @author PC
 */
public class DomainMatch {

    private DomainPool domainPool;
    private Player[] players;
    
    public DomainMatch(Player[] players) {
                      
        this.players = players;
    }

    public LinkedList<Tile> getTiles() {
        LinkedList<Tile> tiles;
      //  tiles = pool.getTiles();
        return null;
    }
    
    public Tile searchHighestMule(LinkedList<Tile>  tiles) throws PoolException {
    return null;
        //   return pool.getHighestMuleOfList(tiles);
    }   

    
    //Escuhcar click al pozo
    
    //Hacer logica.
    
    public void swichtTilesPossesionToPlayer(Player player, LinkedList<Tile> tiles) throws PlayerException {
     player.addTiles(tiles);
    }
    
    public void swichtTilePossesionToPlayer(Player player, Tile tile) throws PlayerException {
     player.addTile(tile);
    }

    
    
}
