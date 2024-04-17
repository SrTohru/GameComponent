/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.events.BoardEvents;
import org.itson.events.PlayerEvents;
import org.itson.events.PoolEvents;
import org.itson.mvc.tile.TileComponent;

/**
 *
 * @author PC
 */
public interface MatchObserver {

    void eventOnPoolUpdate(PoolEvents evt);
    void eventOnBoardUpdate(BoardEvents evt);
    void eventOnPlayerUpdate(PlayerEvents evt);
    void eventOnPlayerClickedTile(PlayerEvents evt, TileComponent tile);
}
