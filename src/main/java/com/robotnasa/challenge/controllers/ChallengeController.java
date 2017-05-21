package com.robotnasa.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robotnasa.challenge.models.Robot;
import com.robotnasa.challenge.models.SurfaceArea;

/*
 * Author: Urique Hoffmann
 * 
 * Controller Class that handle the REST request. 
 * It receives an url command then tries to apply for the robot. 
 * It returns http status 200 and the robot position for possible commands. 
 * It returns http status 400 and a message of Bad Request for impossible commands.
 *  
 * */

@RestController
@RequestMapping(ChallengeController.CHALLENGE_BASE_URL)
public class ChallengeController {
	public static final String CHALLENGE_BASE_URL = "rest/mars";
	
	@RequestMapping("{commands}")
	public ResponseEntity getResult(@PathVariable final String commands) {
		SurfaceArea Area = new SurfaceArea();
		Robot Robot = new Robot(Area);
		for(int i=0; i < commands.length(); i++){
			// Check if the robot is trying to make an impossible move
			if (!Robot.isMovementAvaliable(commands.charAt(i))) {
				return new ResponseEntity<>("400 Bad Request\n",HttpStatus.BAD_REQUEST);
			}
			if (commands.charAt(i) == 'R') {
				Robot.turnRight();
			}
			else if (commands.charAt(i) == 'L') {
				Robot.turnLeft();
			}
			else {
				Robot.goForward();
			}
			// Check if the robot is inside the area
			if (!Robot.isRobotInArea()) {
				return new ResponseEntity<>("400 Bad Request\n", HttpStatus.BAD_REQUEST);
			}
		}
		// Build response message
		String response = "("+Robot.getPositionX()
		+","+Robot.getPositionY()+","+Robot.getDirection()+")\n";
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
