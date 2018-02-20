package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddlePositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {

	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		//move forward initially 
		final double TURN_TIME = 2;
		final double TURN_SPEED = 0.35;
		command.addSequential(new TimedDrive(1, 0.5, 0.5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));
		
		command.addSequential(new TimedDrive(2, .5, .5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		command.addSequential(new AutoDrive(9));
	}
}
