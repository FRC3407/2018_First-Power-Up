package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

public abstract class AbstractAutoDropAtSwitchCommandBuilder extends AbstractAutoCommandBuilder {
	
	private double initialWait = 1.0;

	@Override
	protected Command build(Direction direction) {
		CommandGroup command = new CommandGroup();
		
		if (initialWait > 0) {
			command.addSequential(new PrintCommand("Waiting " + initialWait + " seconds"));
			command.addSequential(new WaitCommand(initialWait));
		}
		
		command.addSequential(new PrintCommand("Drive Maneuver"));
		addDriveManeuver(direction, command);
		
		command.addSequential(new PrintCommand("Lowering arm"));
		addLowerArms(command);
		
		command.addSequential(new PrintCommand("Open Sesame"));		
		addOpenArms(command);

		command.addSequential(new PrintCommand("Autonomous Command is DONE"));		

		return command;
	}
	
	protected abstract void addDriveManeuver(Direction direction, CommandGroup command);
	
	protected void addLowerArms(CommandGroup command) {
		command.addSequential(new TimedLiftCommand(3, TimedLiftCommand.Direction.RAISE));		
	}

	protected void addOpenArms(CommandGroup command) {
		command.addSequential(new TimedOpenCommand(3));
	}
}
