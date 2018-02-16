package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public abstract class AutoCommandAbstract extends Command {
	boolean isLeft;
    public AutoCommandAbstract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the 3first time
    protected void initialize() {
    	isLeft = Robot.weekZeroGameInfo.isSwitchLeft();
    }
    protected abstract void left();
    protected abstract void right();
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isLeft) {
    		left();
    	} else {
    		right();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
