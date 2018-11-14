package Minesweeper;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Tile {

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
	private Tile north;
	private Tile south;
	private Tile east;
	private Tile west;
	private Tile northEast;
	private Tile northWest;
	private Tile southEast;
	private Tile southWest;
	private JButton button;
	
	public Tile(boolean isMine, int x, int y) {
		button = new JButton();
		button.setPreferredSize(new Dimension(30, 30));
		if (isMine) {
			type = 10;
		} else {
			type = 0;
		}
		xcoord = x;
		ycoord = y;
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
	public JButton getButton() {return button;}
	public int getXCoord() {return xcoord;}
	public int getYCoord() {return ycoord;}
	public int getType() {return type;}
	
//--------Setters--------------------------------------------------------------------------
	
	public void setNorth(Tile n) {north = n; north.setSouth(this);}
	public void setSouth(Tile s) {south = s; south.setNorth(this);}
	public void setEast(Tile e) {east = e; east.setWest(this);}
	public void setWest(Tile w) {west = w; west.setEast(this);}
	public void setNorthEast(Tile ne) {northEast = ne; northEast.setSouthWest(this);}
	public void setNorthWest(Tile nw) {northWest = nw; northWest.setSouthEast(this);}
	public void setSouthEast(Tile se) {southEast = se; southEast.setNorthWest(this);}
	public void setSouthWest(Tile sw) {southWest = sw; southWest.setNorthEast(this);}
	public void setType(int t) {type = t;}
	
//----------------------------------------------------------------------------------------
	
	public void setButtonListener(ActionListener a) {
		button.addActionListener(a);
	}
}
