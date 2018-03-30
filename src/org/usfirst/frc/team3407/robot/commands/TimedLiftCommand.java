package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedLiftCommand extends TimedCommand {

	public enum Direction {
		RAISE(true), LOWER(false);
		
		protected boolean value;
		private Direction(boolean value) {
			this.value = value;
		}
	}
	
	private Direction direction;
	
    public TimedLiftCommand(double timeout, Direction direction) {
    	super(timeout);
    	this.direction = direction;
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {//TODO: update this 
    	//Robot.lift.move(direction.value);
    	if(direction.value) {
    		Robot.lift.moveUp();
    	}else {
    		Robot.lift.moveDown();
    	}
    }

    // Called once after timeout
    protected void end() {
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.stop();
    }
}
