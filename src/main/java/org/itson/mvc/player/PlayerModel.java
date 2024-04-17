/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.player;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.domain.Tile;
import org.itson.enums.ImagesSourcers;
import org.itson.mvc.tile.TileComponent;

/**
 *
 * @author santi
 */
public class PlayerModel {

    private Player player;

    private LinkedList<Player> players;

    private String avatarPath;

    private String name;

    public LinkedList<TileComponent> tiles = new LinkedList<>();

    public int turn;

    private int width;//= 100;

    private int height;//= 100;

    private int coordX;//= 0;

    private int coordY;//= 0;

    public PlayerModel(int width, int height, int coordX, int coordY) {
        this.width = width;
        this.height = height;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public PlayerModel(Player player, String avatarSelected) {
        this.player = player;
        this.name = avatarSelected;
        this.avatarPath = getAvatarImage(this.name);

    }

    public static String getAvatarImage(String name) {
        return switch (name) {
            case "El_Gallo" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_Gallo();
            case "La_dama" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_La_dama();
            case "La_chalupa" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_La_chalupa();
            case "El_diablito" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_diablito();
            case "El_sol" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_sol();
            case "El_borracho" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_borracho();
            case "El_apache" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_apache();
            case "El_Valiente" ->
                ImagesSourcers.getSOURCE_IMAGE_AVATAR_El_Valiente();
            default ->
                null;
        };
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public TileComponent addTile(TileComponent tile) {

        this.getTiles().add(tile);

        return tile;
    }

    public LinkedList<TileComponent> getTiles() {
        return tiles;
    }

    public void setTiles(LinkedList<TileComponent> tiles) {
        this.tiles = tiles;
    }

    public TileComponent removeTile(TileComponent tile) {
        this.tiles.remove(tile);
        return tile;
    }

}
