package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

public abstract class AbstractAutoCommandBuilder {
	
	public enum Direction { 
		LEFT, RIGHT;
		public Direction getOpposite() { return (this == Direction.LEFT) ? Direction.RIGHT : Direction.LEFT; };
	};

	public static Command buildTurnCalibration() {
		CommandGroup command = new CommandGroup();
		
		double[] turnDegreeArray = { 90.0, -90.0, 45.0, -45.0 };
		for (double turnDegree : turnDegreeArray) {
			String test = String.format("Calibrating turn of %s degrees", turnDegree);
			System.out.println("Building command: " + test);
			command.addSequential(new PrintCommand(test));
			command.addSequential(buildInPlaceTurn(turnDegree));				
			command.addSequential(new WaitCommand(2));
		}
		
		return command;
	}

	protected static Command buildInPlaceTurn(double degrees) {
		final double TURN_DEGREES_PER_SECOND = 45;
		final double TURN_SPEED = 0.35;
		
		double leftSpeed = TURN_SPEED;
		double rightSpeed = TURN_SPEED;
		if (degrees < 0) {
			leftSpeed = -TURN_SPEED;
		} 
		else {
			rightSpeed = -TURN_SPEED;			
		}
		
		double time = Math.abs(degrees) / TURN_DEGREES_PER_SECOND;
		
		return new TimedDrive(time, leftSpeed, rightSpeed);    	
	}
	
	public Command build() {
		Command leftCommand = build(Direction.LEFT);
		Command rightCommand = build(Direction.RIGHT);
		
		return new ConditionalAutoCommand(leftCommand, rightCommand);
	}
	
	protected abstract Command build(Direction direction);
}
