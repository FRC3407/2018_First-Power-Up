package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddlePositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {

	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		final double TURN_DEGREES = 90.0;

		//move forward initially 
		command.addSequential(new TimedDrive(1, 0.5, 0.5));

		// Turn 90 degrees in specified direction, left is negative
		double turnDegrees = (direction == Direction.LEFT) ? -TURN_DEGREES : TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		//drive across the field
		command.addSequential(new TimedDrive(2, .5, .5));
		
		// Turn in the specified direction, left is now positive 
		turnDegrees = (direction == Direction.LEFT) ? TURN_DEGREES : -TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		//drive to switch
		command.addSequential(new AutoDrive(12));
	}
}
