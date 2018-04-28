package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MiddlePositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {

	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		//move forward initially 
		final double TURN_TIME = 1;
		final double TURN_SPEED = 0.47;
		command.addSequential(new TimedDrive(1, 0.6, 0.6));
		command.addSequential(new WaitCommand(1));
		//turn 90 degrees
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));
		command.addSequential(new WaitCommand(1));
		//drive across the field
		command.addSequential(new TimedDrive(2, .6, .655));
		command.addSequential(new WaitCommand(1));
		//turn 90 degrees back to the initial orientation
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		command.addSequential(new WaitCommand(1));
		//drive to switch
		command.addSequential(new TimedDrive(2, .6, .655));
	}
}
