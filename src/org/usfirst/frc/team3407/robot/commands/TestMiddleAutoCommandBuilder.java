package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.commands.AbstractAutoCommandBuilder.Direction;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class TestMiddleAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {
	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		//move forward initially 
		final double TURN_TIME = .5;
		final double TURN_SPEED = 0.53;
		command.addSequential(new TimedDrive(.3, .5, .53));
		command.addSequential(new TimedDrive(.5,getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));
		
		command.addSequential(new TimedDrive(6, .5, .53));
		command.addSequential(new AutoDrive(2));
		
	}
}
