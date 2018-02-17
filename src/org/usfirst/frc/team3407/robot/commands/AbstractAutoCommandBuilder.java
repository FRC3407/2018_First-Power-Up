package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AbstractAutoCommandBuilder {

	public Command build() {
		Command leftCommand = build(true);
		Command rightCommand = build(false);
		
		return new ConditionalAutoCommand(leftCommand, rightCommand);
	}
	
	protected abstract Command build(boolean switchLeft);
}
