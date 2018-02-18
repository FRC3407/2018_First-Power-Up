package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AbstractAutoCommandBuilder {
	
	public enum Direction { 
		LEFT, RIGHT;
		public Direction getOpposite() { return (this == Direction.LEFT) ? Direction.RIGHT : Direction.LEFT; };
	};

	public Command build() {
		Command leftCommand = build(Direction.LEFT);
		Command rightCommand = build(Direction.RIGHT);
		
		return new ConditionalAutoCommand(leftCommand, rightCommand);
	}
	
	protected abstract Command build(Direction direction);
}
