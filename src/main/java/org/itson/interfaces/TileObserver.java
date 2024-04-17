/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.domaincomponent.domain.Tile;
import org.itson.events.TileEvents;

/**
 *
 * @author paulvazquez
 */
public interface TileObserver {
    void eventOnTileUpdate(TileEvents evt, Tile tile);
}
