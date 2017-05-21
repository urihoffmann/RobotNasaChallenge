package com.robotnasa.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.robotnasa.challenge.models.Robot;
import com.robotnasa.challenge.models.SurfaceArea;

@RestController
@RequestMapping(ChallengeController.CHALLENGE_BASE_URL)
public class ChallengeController {
	public static final String CHALLENGE_BASE_URL = "rest/mars";
	
	@RequestMapping("{commands}")
	public ResponseEntity getResult(@PathVariable final String commands) {
		SurfaceArea Area = new SurfaceArea();
		Robot Robot = new Robot(Area);
		for(int i=0; i < commands.length(); i++){
			char moviment = commands.charAt(i);
			
			if (!Robot.isMovimentAvaliable(moviment)) {
				return new ResponseEntity<>("400 Bad Request\n",HttpStatus.BAD_REQUEST);
			}
			if (moviment == 'R') {
				Robot.turnRight();
			}
			else if (moviment == 'L') {
				Robot.turnLeft();
			}
			else {
				Robot.goForward();
			}
			if (!Robot.isRobotInArea()) {
				return new ResponseEntity<>("400 Bad Request\n", HttpStatus.BAD_REQUEST);
			}
		}
		String response = "("+Robot.getPositionX()
		+","+Robot.getPositionY()+","+Robot.getDirection()+")\n";
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
