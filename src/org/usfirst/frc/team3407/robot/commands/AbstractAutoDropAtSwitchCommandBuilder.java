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
	
	// This is a near switch maneuver
	//
	//       |
	//       /
	//      /
	//      |
	//      |
	//      |
	//      |
	//
	protected void addNearDriveManeuver(Direction direction, CommandGroup command) {
		
		final double TURN_TIME = 1.5;
		final double TURN_SPEED = 0.7;
		
		command.addSequential(new TimedDrive(5.0, 0.6, 0.6));    
		command.addSequential(new WaitCommand(0.5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));  
		
		command.addSequential(new TimedDrive(2.0, 0.6, 0.6));    
		command.addSequential(new WaitCommand(0.5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		
		command.addSequential(new TimedDrive(2.0, 0.6, 0.6));    
	}
	
	// This is a far switch maneuver
	//
	//                              |
	//                              |
	//                              |
	//                              |
	//      ________________________|
	//      |
	//      |
	//
	protected void addFarDriveManeuver(Direction direction, CommandGroup command) {
		
		final double TURN_TIME = 3.0;
		final double TURN_SPEED = 0.7;
		
		command.addSequential(new TimedDrive(1.0, 0.6, 0.6));    
		command.addSequential(new WaitCommand(0.5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));  
		
		command.addSequential(new TimedDrive(5.0, 0.8, 0.8));    
		command.addSequential(new WaitCommand(0.5));
		
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		
		command.addSequential(new TimedDrive(5.0, 0.6, 0.6));    
	}

	private double getLeftSpeedForTurn(double speed, Direction direction) {
		return (direction == Direction.LEFT) ? -1.0 * speed : speed;
	}
	
	private double getRightSpeedForTurn(double speed, Direction direction) {
		return (direction == Direction.RIGHT) ? -1.0 * speed : speed;
	}
}
