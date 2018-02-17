package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LeftPositionAutoCommandBuilder extends AbstractAutoCommandBuilder {
	
	@Override
	protected Command build(boolean switchLeft) {
		CommandGroup command = new CommandGroup();
		
		command.addSequential(new WaitCommand(3));
		
		if (switchLeft) {
			command.addSequential(new TimedDrive(1, 0.7, 0.7));  // Replace with AutoDrive??
		} else {
			command.addSequential(new TimedDrive(1, 0.7, 0.7));  // Replace with Drive Steps??			
		}
		
		command.addSequential(new TimedLiftCommand(2, TimedLiftCommand.Direction.LOWER));
		command.addSequential(new TimedOpenCommand(1));
		
		return command;
	}

}
