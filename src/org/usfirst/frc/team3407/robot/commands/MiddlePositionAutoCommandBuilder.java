package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddlePositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {

	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		command.addSequential(new TimedDrive(0.5, 0.5, 0.5));  // Replace with AutoDrive??
	}
}
