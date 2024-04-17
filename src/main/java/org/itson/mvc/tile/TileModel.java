/**
 * TileModel.java
 * Oct 10, 2023 11:05:40 AM
 */
package org.itson.mvc.tile;

import org.itson.domaincomponent.domain.FaceTile;
import org.itson.domaincomponent.domain.Tile;
import org.itson.domaincomponent.enums.Orientation;
import org.itson.domaincomponent.enums.Side;
import org.itson.enums.ImagesSourcers;

/**
 * This class represents the model of the tile, using the MVC model.
 *
 * 
 * @author Santiago Bojórquez Leyva ID:228475
 * @author Paul Alejandro Vazquez Cervantes ID:241400
 * @author Jose Eduardo Hinojosa Romero ID: 2356666
 */
public class TileModel {

    private Tile tile;

    private String firstFacePath;

    private String secondFacePath;

    private int height = 80;

    private int width = 80;

    private int cordX;

    private int cordY;

    /**
     * Default constructor
     */
    public TileModel() {

    }

    /**
     * Constructor for a tile, with first face and second face without
     * orientation, because the orientation default is Vertical
     *
     * @param tile is a tile
     */
    public TileModel(Tile tile) {
        this.tile = tile;
        this.firstFacePath = getFaceTileImage(tile.getFirstFace());
        this.secondFacePath = getFaceTileImage(tile.getSecondFace());
    }

    public static String getFaceTileImage(FaceTile faceTile) {
        switch (faceTile.getValue()) {
            case 0:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_0();
            case 1:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_1();
            case 2:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_2();
            case 3:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_3();
            case 4:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_4();
            case 5:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_5();
            case 6:
                return ImagesSourcers.getSOURCE_IMAGE_TILE_FACE_6();
            default:
                return null;
        }
    }

    /**
     * Rotates the faces of a tile based on the given orientation. This method
     * adjusts the sides of the faces to match the specified orientation, either
     * Horizontal or Vertical.
     *
     * @param orientation The desired orientation for the tile (Horizontal or
     * Vertical).
     */
    private void doRotationByOrientationDefault(Orientation orientation) {

        if (orientation == Orientation.VERTICAL) {
            tile.getFirstFace().setSide(Side.TOP);
            tile.getFirstFace().setSide(Side.BOTTOM);
        }

        if (orientation == Orientation.HORIZONTAL) {
            tile.getFirstFace().setSide(Side.LEFT);
            tile.getFirstFace().setSide(Side.RIGHT);
        }

    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public String getFirstFacePath() {
        return firstFacePath;
    }

    public void setFirstFacePath(String firstFacePath) {
        this.firstFacePath = firstFacePath;
    }

    public String getSecondFacePath() {
        return secondFacePath;
    }

    public void setSecondFacePath(String secondFacePath) {
        this.secondFacePath = secondFacePath;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width * 2;
    }

    /**
     *
     */
    public void doRotation() {
        tile.getFirstFace().turnSide();
        tile.getFirstFace().turnSide();
    }

    /**
     * Get id of the tile
     *
     * @return Id of the tile
     */
    public int getId() {
        return tile.getId();
    }

    /**
     * Set the id of the tile
     *
     * @param id Id of the tile
     */
    public void setId(int id) {
        this.tile.setId(id);
    }

    /**
     * Get the first face of the face
     *
     * @return First face of the tile
     */
    public FaceTile getFirsFace() {
        return tile.getFirstFace();
    }

    /**
     * Set the first face of the tile
     *
     * @param firsFace First face of the tile
     */
    public void setFirsFace(FaceTile firsFace) {
        this.tile.setFirstFace(firsFace);
    }

    /**
     * Get the second face of the tile
     *
     * @return Second face of the tile
     */
    public FaceTile getSecondFace() {
        return this.tile.getSecondFace();
    }

    /**
     * Set the second face of the tile
     *
     * @param secondFace Second face of the tile
     */
    public void setSecondFace(FaceTile secondFace) {
        this.tile.setSecondFace(secondFace);
    }

    /**
     * Get Orientation of the tile (Horizontal, Vertical)
     *
     * @return Orientation of the tile (Horizontal, Vertical)
     */
    public Orientation getOrientation() {
        return this.tile.getOrientation();
    }

    /**
     * Set orientation of the tile, Horizontal or Vertical
     *
     * @param orientation Orientation, Horizontal or Vertical
     */
    public void setOrientation(Orientation orientation) {
        this.tile.setOrientation(orientation);
    }

    /**
     * Verified whether the tile is a mule.
     *
     * @return If it's a mule, then true; otherwise, false.
     */
    public boolean isMule() {

        int firstFaceValue = this.tile.getFirstFace().getValue();
        int secondFaceValue = this.tile.getSecondFace().getValue();

        return firstFaceValue == secondFaceValue;
    }

    /**
     * Resize tile to the specified dimensions.
     *
     * @param width The new width for the tile.
     * @param height The new height for the tile.
     */
    public void resizeTile(int width, int height) {

        int newHeight = height / 2;

//        this.firstFace.refreshImage(width, newHeight);
//        this.secondFace.refreshImage(width, newHeight);
    }

    /**
     * Retrieves the width of a composite image formed by combining the widths
     * of the two faces of a tile. The width is calculated as the average of the
     * widths of the first and second faces.
     *
     * @return The width of the composite image.
     */
    public int getWidth() {

        return this.width;

    }

    /**
     * Retrieves the height of a composite image formed by combining the heights
     * of the two faces of a tile. The height is calculated as the sum of the
     * heights of the first and second faces.
     *
     * @return The height of the composite image.
     */
    public int getHeight() {

        return this.height;
    }

    @Override
    public String toString() {
        return "TileModel{" + "tile=" + tile + ", height=" + height + ", width=" + width + ", cordX=" + cordX + ", cordY=" + cordY + '}';
    }

}
