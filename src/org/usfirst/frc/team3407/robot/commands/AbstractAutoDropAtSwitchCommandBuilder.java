package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class AbstractAutoDropAtSwitchCommandBuilder extends AbstractAutoCommandBuilder {
	
	private double initialWait = 1.0;

	public AbstractAutoDropAtSwitchCommandBuilder() {
		// Get initial wait from DashBoard
		boolean useDashBoard = SmartDashboard.getBoolean("DB/Button 1", false);
		if (useDashBoard) {
			initialWait = SmartDashboard.getNumber("DB/Slider 1", 0.0);
			System.out.println("Initial wait set from dashboard: " + initialWait);
		}
	}
	
	@Override
	protected Command build(Direction direction) {
		CommandGroup command = new CommandGroup();
		
		if (initialWait > 0) {
			command.addSequential(new PrintCommand("Waiting " + initialWait + " seconds"));
			command.addSequential(new WaitCommand(initialWait));
		}
		command.addSequential(new PrintCommand("Drive Maneuver"));
		addDriveManeuver(direction, command);
		
		command.addParallel(new TimedLiftCommand(0.5, TimedLiftCommand.Direction.LOWER));
		
		command.addSequential(new PrintCommand("Lowering arm"));
		addLowerArms(command);
		
		command.addSequential(new PrintCommand("Open Sesame"));		
		addOpenArms(command);

		command.addSequential(new PrintCommand("Autonomous Command is DONE"));		

		return command;
	}
	
	protected abstract void addDriveManeuver(Direction direction, CommandGroup command);
	
	protected void addLowerArms(CommandGroup command) {
		command.addSequential(new TimedLiftCommand(3, TimedLiftCommand.Direction.LOWER));		
	}

	protected void addOpenArms(CommandGroup command) {
		command.addSequential(new TimedOpenCommand(3));
	}
	
	// This is a near switch maneuver.  For example if direction is right, then the
	// path is below.  Left direction is mirror image.  Used from left and middle
	// position.
	//
	//
	//          |
	//		    |
	//          | 
	//      ----|
	//      |
	//      |
	//
	protected void addNearDriveManeuver(Direction direction, CommandGroup command) {
		
		final double TURN_TIME = 1;
		final double TURN_SPEED = 0.47;
		
		// Initial forward
		command.addSequential(new TimedDrive(.5, 0.5, 0.5));    
		command.addSequential(new WaitCommand(1));
		
		// Turn in the specified direction 
		//TODO: ask about if we can just set up in front of the switch. 
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));  
		
		// Drive horizontal
		//is this enough? should have had it all sketched out before now. 
		command.addSequential(new TimedDrive(1.0, 0.5, 0.5));    
		command.addSequential(new WaitCommand(2));
		
		// Turn opposite of the specified direction to face the switch wall 
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite()))); 
		// a lot of time to just move forward, maybe go for second (or third) cube?
		command.addSequential(new AutoDrive(10));
	}
	
	// This is a far switch maneuver.  For example if direction is right, then the
	// path is below.  Left direction is mirror image.  Used from left and right positions to
	// cross playing field.			
	//							    |
	//								|
	//                              |
	//                              |
	//                              |
	//                              |
	//      ________________________|
	//      |
	//      |
	//
	protected void addFarDriveManeuver(Direction direction, CommandGroup command) {
		
		final double TURN_TIME = 1.0;
		final double TURN_SPEED = 0.47;
		
		// Initial forward
		command.addSequential(new TimedDrive(.5, 0.5, 0.5));    
		command.addSequential(new WaitCommand(1));
		
		// Turn 90 degrees in specified direction
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction), 
				getRightSpeedForTurn(TURN_SPEED, direction)));  
		
		// Drive across field
		command.addSequential(new TimedDrive(3, 0.6, 0.6));    
		command.addSequential(new WaitCommand(3));
		
		// Turn opposite of the specified direction to face the switch wall 
		command.addSequential(new TimedDrive(TURN_TIME, 
				getLeftSpeedForTurn(TURN_SPEED, direction.getOpposite()), 
				getRightSpeedForTurn(TURN_SPEED, direction.getOpposite())));  
		
		// Drive to wall
		//def enough time here to get another cube
		command.addSequential(new AutoDrive(7));    
	}

	protected double getLeftSpeedForTurn(double speed, Direction direction) {
		return (direction == Direction.LEFT) ? -1.0 * speed : speed;
	}
	
	protected double getRightSpeedForTurn(double speed, Direction direction) {
		return (direction == Direction.RIGHT) ? -1.0 * speed : speed;
	}
}
