package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LeftPositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {
	
	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		if (direction == Direction.LEFT) {
			command.addSequential(new TimedDrive(4, 0.6, 0.6));  // Replace with AutoDrive??
			command.addSequential(new WaitCommand(1.5));
			command.addSequential(new TimedDrive(2.5, 0.7, -0.7));  // Replace with AutoDrive??
			//command.addSequential(new AutoDrive());
		} else {
			// Add commands for driving to right side
		}		
	}
}
