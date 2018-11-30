package Minesweeper;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Tile extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xcoord;
	private int ycoord;
	private int type;
	/*
	 * 0 is neutral
	 * 1 is 1 mine nearby
	 * 2 is 2 mines nearby
	 * ...
	 * 8 is 8 mines nearby
	 * 9 is a mine
	 */
	private boolean isFlag;
	private boolean isDug;
	private Tile north;
	private Tile south;
	private Tile east;
	private Tile west;
	private Tile northEast;
	private Tile northWest;
	private Tile southEast;
	private Tile southWest;
	
	public Tile(boolean isMine, int x, int y) {
		if (isMine) {
			type = 9;
		} else {
			type = 0;
		}
		xcoord = x;
		ycoord = y;
		isFlag = false;
		isDug = false;
	}
//-------Getters----------------------------------------------------------------------------

	public Tile getNorth() {return north;}
	public Tile getSouth() {return south;}
	public Tile getEast() {return east;}
	public Tile getWest() {return west;}
	public Tile getNorthEast() {return northEast;}
	public Tile getNorthWest() {return northWest;}
	public Tile getSouthEast() {return southEast;}
	public Tile getSouthWest() {return southWest;}
	public int getXCoord() {return xcoord;}
	public int getYCoord() {return ycoord;}
	public int getType() {return type;}
	public boolean getIsFlag() {return isFlag;}
	public boolean getIsDug() {return isDug;}
	
//--------Setters--------------------------------------------------------------------------
	
	public void setNorth(Tile n) {north = n;}
	public void setSouth(Tile s) {south = s;}
	public void setEast(Tile e) {east = e;}
	public void setWest(Tile w) {west = w;}
	public void setNorthEast(Tile ne) {northEast = ne;}
	public void setNorthWest(Tile nw) {northWest = nw;}
	public void setSouthEast(Tile se) {southEast = se;}
	public void setSouthWest(Tile sw) {southWest = sw;}
	public void setType(int t) {type = t;}
	public void setIsFlag(boolean foo) {isFlag = foo;}
	public void setIsDug(boolean foo) {isDug = foo;}
	
//----------------------------------------------------------------------------------------
	
	public void setButtonListener(ActionListener a) {
		this.addActionListener(a);
	}
}
