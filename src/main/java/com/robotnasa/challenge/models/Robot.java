package com.robotnasa.challenge.models;

/*
 * Author: Urique Hoffmann
 * 
 * Class that implements the Robot properties and behavior during the movements. 
 * */

public class Robot {
	
	private int positionX;
	private int positionY;
	private int direction;
	private String[] directions = {"N","E","S","W"};
	private SurfaceArea Area;
	
	// Constructor, A robot must be created in an Available area
	public Robot(SurfaceArea Area) {
		this.setInitialPositions();
		this.Area = Area;
	}
	// Initialize the Robot
	public void setInitialPositions(){
		this.positionX = 0;
		this.positionY = 0;
		this.direction = 0;
	}
	// Makes movement in x axis
	public void incrementPositionX(){
		this.positionX+=1;
	}
	// Makes movement in y axis
	public void incrementPositionY(){
		this.positionY+=1;
	}
	// Makes movement in x axis
	public void decrementPositionX(){
		this.positionX-=1;
	}
	// Makes movement in y axis
	public void decrementPositionY(){
		this.positionY-=1;
	}
	// returns the position of the robot in x axis
	public int getPositionX() {
		return this.positionX;
	}
	// returns the position of the robot in y axis
	public int getPositionY() {
		return this.positionY;
	}
	// returns the direction the robot is pointed to
	public String getDirection() {
		return this.directions[this.direction];
	}
	// implements the turning right robot behavior 
	public void turnRight() {
		if (this.direction == this.directions.length-1) {
			this.direction = 0;
		}
		else {
			this.direction += 1;
		}
	}
	// implement the turning left robot behavior
	public void turnLeft() {
		if (this.direction == 0) {
			this.direction = this.directions.length-1;
		}
		else {
			this.direction -= 1;
		}
	}
	// implement the movement of going forward
	// the movement depends on the direction
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
	// check is a movement is available
	public boolean isMovementAvaliable(char movement) {
		if (movement != 'L' && movement != 'R' && movement != 'M') {
			return false;
		}
		return true;
	}
	// check if the robot in in the surface area
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
