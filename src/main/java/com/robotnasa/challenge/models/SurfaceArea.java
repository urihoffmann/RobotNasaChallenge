package com.robotnasa.challenge.models;

public class SurfaceArea {

	private int areaX;
	private int areaY;
	
	public SurfaceArea() {
		this.setArea(4, 4);
	}
	
	public SurfaceArea(int x, int y){
		this.setArea(x-1, y-1);
	}
	
	public void setArea(int x, int y){
		this.areaX = x;
		this.areaY = y;
	}
	
	public void setAreaX(int x){
		this.areaX = x;
	}
	
	public void setAreaY(int y){
		this.areaY = y;
	}
	
	public int getAreaX() {
		return this.areaX;
	}
	
	public int getAreaY() {
		return this.areaY;
	}
	
	
}
