package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LeftPositionAutoCommandBuilder extends AbstractAutoCommandBuilder {
	
	@Override
	protected Command build(boolean switchLeft) {
		CommandGroup command = new CommandGroup();
		
		//command.addSequential(new PrintCommand("Waiting 2 seconds"));
		//command.addSequential(new WaitCommand(2));
		
		command.addSequential(new PrintCommand("Drive Maneuver"));
		if (switchLeft) {
			command.addSequential(new TimedDrive(3, 0.5, 0.5));  // Replace with AutoDrive??
			command.addSequential(new TimedDrive(1, 0.5, -0.5));  // Replace with AutoDrive??
			//command.addSequential(new AutoDrive());
		} else {
			command.addSequential(new TimedDrive(2, 0.5, 0.5));  // Replace with Drive Steps??			
			//command.addSequential(new DriveSteps());
		}
		
		command.addSequential(new PrintCommand("Lowering arm"));
		command.addSequential(new TimedLiftCommand(5, TimedLiftCommand.Direction.LOWER));
		
		command.addSequential(new PrintCommand("Open Sesame"));		
		command.addSequential(new TimedOpenCommand(1));

		command.addSequential(new PrintCommand("Autonomous Command is DONE"));		

		return command;
	}

}
