package com.robotnasa.challenge.models;

public class Robot {
	
	private int positionX;
	private int positionY;
	private int direction;
	private String[] directions = {"N","E","S","W"};
	private SurfaceArea Area;
	
	public Robot(SurfaceArea Area) {
		this.setInitialPositions();
		this.Area = Area;
	}
	
	public void setInitialPositions(){
		this.positionX = 0;
		this.positionY = 0;
		this.direction = 0;
	}

	public void incrementPositionX(){
		this.positionX+=1;
	}
	
	public void incrementPositionY(){
		this.positionY+=1;
	}
	
	public void decrementPositionX(){
		this.positionX-=1;
	}
	
	public void decrementPositionY(){
		this.positionY-=1;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public String getDirection() {
		return this.directions[this.direction];
	}
	
	public void turnRight() {
		if (this.direction == this.directions.length-1) {
			this.direction = 0;
		}
		else {
			this.direction += 1;
		}
	}
	
	public void turnLeft() {
		if (this.direction == 0) {
			this.direction = this.directions.length-1;
		}
		else {
			this.direction -= 1;
		}
	}
	
	public void goForward() {
		String currentPosition = this.getDirection();
		if (currentPosition == "N") {
			this.positionY += 1;
		}
		else if (currentPosition == "E") {
			this.positionX += 1;
		}
		else if (currentPosition == "S") {
			this.positionY -= 1;
		}
		else {
			this.positionX -= 1;
		}
	}
	
	public boolean isMovimentAvaliable(char moviment) {
		if (moviment != 'L' && moviment != 'R' && moviment != 'M') {
			return false;
		}
		return true;
	}
	
	public boolean isRobotInArea() {
		if (this.positionX > this.Area.getAreaX() || this.positionY > this.Area.getAreaY()) {
			return false;
		}
		else if (this.positionX < 0 || this.positionY < 0) {
			return false;
		}
		
		return true;
	}
	
}
