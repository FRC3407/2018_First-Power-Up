package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.RobotMap;

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
		
		command.addSequential(new PrintCommand("Lowering arm"));
		addLowerArms(command);
		
		if (RobotMap.hasArms()) {
			command.addSequential(new PrintCommand("Open Sesame"));		
			addOpenArms(command);
		} else {
			command.addSequential(new PrintCommand("Open Arms (woudl happen no if there were any)"));					
		}

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
	//         |
	//		  /
	//       /
	//      /
	//      |
	//      |
	//
	protected void addNearDriveManeuver(Direction direction, CommandGroup command) {
		
		final double TURN_DEGREES = 45.0;
		
		// Initial forward
		command.addSequential(new TimedDrive(.5, 0.5, 0.5));    
		command.addSequential(new WaitCommand(0.5));
		
		// Turn in the specified direction, left is negative 
		double turnDegrees = (direction == Direction.LEFT) ? -TURN_DEGREES : TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		// Drive diagonal 
		command.addSequential(new TimedDrive(1.0, 0.5, 0.5));    
		command.addSequential(new WaitCommand(0.5));
		
		// Turn in the specified direction, left is now positive 
		turnDegrees = (direction == Direction.LEFT) ? TURN_DEGREES : -TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		// Drive to switch plate
		command.addSequential(new AutoDrive(12));
	}
	
	// This is a far switch maneuver.  For example if direction is right, then the
	// path is below.  Left direction is mirror image.  Used from left and right positions to
	// cross playing field.
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
		
		final double TURN_DEGREES = 90.0;
		
		// Initial forward
		command.addSequential(new TimedDrive(1.0, 0.5, 0.5));    
		command.addSequential(new WaitCommand(0.5));
		
		// Turn 90 degrees in specified direction, left is negative
		double turnDegrees = (direction == Direction.LEFT) ? -TURN_DEGREES : TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		// Drive across field
		command.addSequential(new TimedDrive(4, 0.5, 0.5));    
		command.addSequential(new WaitCommand(0.5));
		
		// Turn in the specified direction, left is now positive 
		turnDegrees = (direction == Direction.LEFT) ? TURN_DEGREES : -TURN_DEGREES;
		command.addSequential(buildInPlaceTurn(turnDegrees));
		
		// Drive to wall
		command.addSequential(new AutoDrive(9));    
	}
}
