package com.robotnasa.challenge.models;

/*
 * Author: Urique Hoffmann
 * 
 * Class that implements the Surface Area the Robot will make the moves
 *  
 * */


public class SurfaceArea {

	private int areaX;
	private int areaY;
	// Default area is 5x5 (4x4 considering indexes initializing in 0)
	public SurfaceArea() {
		this.setArea(4, 4);
	}
	// If the dimension is set, then a surface area with this dimension is created
	public SurfaceArea(int x, int y){
		this.setArea(x-1, y-1);
	}
	// setting area dimension
	public void setArea(int x, int y){
		this.areaX = x;
		this.areaY = y;
	}
	// setting only x axis dimension
	public void setAreaX(int x){
		this.areaX = x;
	}
	// setting only y axis dimension
	public void setAreaY(int y){
		this.areaY = y;
	}
	// returns the x axis dimension
	public int getAreaX() {
		return this.areaX;
	}
	// returns the y axis dimension
	public int getAreaY() {
		return this.areaY;
	}
	
	
}
