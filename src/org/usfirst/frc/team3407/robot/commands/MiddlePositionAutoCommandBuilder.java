package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddlePositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {

	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		//move forward initially 
		final double TURN_TIME = 1;
		final double TURN_SPEED = 0.47;
		command.addSequential(new TimedDrive(1, 0.5, 0.5));
		//turn 90 degrees
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));
		//drive across the field
		command.addSequential(new TimedDrive(2, .5, .5));
		//turn 90 degrees back to the initial orientation
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		//drive to switch
		command.addSequential(new AutoDrive(9));
	}
}
