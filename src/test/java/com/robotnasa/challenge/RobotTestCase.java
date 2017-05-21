package com.robotnasa.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

import com.robotnasa.challenge.models.Robot;
import com.robotnasa.challenge.models.SurfaceArea;

public class RobotTestCase {
	
	@Test
	public void testInitialPosition() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.setInitialPositions();
		assertEquals(robot.getPositionX(), 0);
		assertEquals(robot.getPositionY(), 0);
		assertEquals(robot.getDirection(), "N");
	}
	
	@Test
	public void testIncrementPositions() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.incrementPositionX();
		robot.incrementPositionY();
		assertEquals(robot.getPositionX(), 1);
		assertEquals(robot.getPositionY(), 1);
	}
	
	@Test
	public void testDecrementPositions() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		robot.decrementPositionX();
		robot.decrementPositionY();
		assertEquals(robot.getPositionX(), -1);
		assertEquals(robot.getPositionY(), -1);
	}
	
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
	
	@Test
	public void testAvaiableMoviment() {
		SurfaceArea area = new SurfaceArea();
		Robot robot = new Robot(area);
		assertEquals(robot.isMovimentAvaliable('A'), false);
		assertEquals(robot.isMovimentAvaliable('M'), true);
		assertEquals(robot.isMovimentAvaliable('L'), true);
		assertEquals(robot.isMovimentAvaliable('R'), true);
	}
	
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
