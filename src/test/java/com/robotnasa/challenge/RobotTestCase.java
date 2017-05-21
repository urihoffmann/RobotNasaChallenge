package com.robotnasa.challenge;

/*
 * Author: Urique Hoffmann
 * 
 * Class that implements the unit tests to check the robot behavior
 *  
 * */



import static org.junit.Assert.*;

import org.junit.Test;

import com.robotnasa.challenge.models.Robot;
import com.robotnasa.challenge.models.SurfaceArea;

public class RobotTestCase {
	// Should initialize the initial positions of the robot with (0,0,N)
	@Test
	public void testInitialPosition() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.setInitialPositions();
		assertEquals(robot.getPositionX(), 0);
		assertEquals(robot.getPositionY(), 0);
		assertEquals(robot.getDirection(), "N");
	}
	// Should increment robot positions
	@Test
	public void testIncrementPositions() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.incrementPositionX();
		robot.incrementPositionY();
		assertEquals(robot.getPositionX(), 1);
		assertEquals(robot.getPositionY(), 1);
	}
	// Should decrement robot positions
	@Test
	public void testDecrementPositions() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.decrementPositionX();
		robot.decrementPositionY();
		assertEquals(robot.getPositionX(), -1);
		assertEquals(robot.getPositionY(), -1);
	}
	// Should change direction when turn right
	@Test
	public void testTurnRight() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.turnRight();
		assertEquals(robot.getDirection(), "E");
		robot.turnRight();
		assertEquals(robot.getDirection(), "S");
		robot.turnRight();
		assertEquals(robot.getDirection(), "W");
		robot.turnRight();
		assertEquals(robot.getDirection(), "N");
	}
	// Should change direction when turn left
	@Test
	public void testTurnLeft() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.turnLeft();
		assertEquals(robot.getDirection(), "W");
		robot.turnLeft();
		assertEquals(robot.getDirection(), "S");
		robot.turnLeft();
		assertEquals(robot.getDirection(), "E");
		robot.turnLeft();
		assertEquals(robot.getDirection(), "N");
	}
	// Should move the robot in different ways depending from the direction  
	@Test
	public void testGoForward() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
//		North 
		robot.goForward();
		assertEquals(robot.getPositionX(), 0);
		assertEquals(robot.getPositionY(), 1);
//		East
		robot.turnRight();
		robot.goForward();
		assertEquals(robot.getPositionX(), 1);
		assertEquals(robot.getPositionY(), 1);
//		South
		robot.turnRight();
		robot.goForward();
		assertEquals(robot.getPositionX(), 1);
		assertEquals(robot.getPositionY(), 0);
//		West
		robot.turnRight();
		robot.goForward();
		assertEquals(robot.getPositionX(), 0);
		assertEquals(robot.getPositionY(), 0);
		
	}
	// Should return false for an Unavailable movement and true otherwise
	@Test
	public void testAvaiableMovement() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		assertEquals(robot.isMovementAvaliable('A'), false);
		assertEquals(robot.isMovementAvaliable('M'), true);
		assertEquals(robot.isMovementAvaliable('L'), true);
		assertEquals(robot.isMovementAvaliable('R'), true);
	}
	// Should return false if the robot go away from the area
	@Test
	public void testInArea() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.decrementPositionX();
		assertEquals(robot.isRobotInArea(), false);
		
		robot.setInitialPositions();
		robot.decrementPositionY();
		assertEquals(robot.isRobotInArea(), false);
		
		robot.setInitialPositions();
		robot.incrementPositionX();
		robot.incrementPositionX();
		robot.incrementPositionX();
		robot.incrementPositionX();
		robot.incrementPositionX();
		robot.incrementPositionX();
		assertEquals(robot.isRobotInArea(), false);
		
		robot.setInitialPositions();
		robot.incrementPositionX();
		robot.incrementPositionY();
		robot.incrementPositionY();
		robot.incrementPositionY();
		robot.incrementPositionY();
		robot.incrementPositionY();
		assertEquals(robot.isRobotInArea(), false);
	}
	

}
