package org.usfirst.frc.team3407.robot.commands;


/**
 *
 */
public class MiddleAutoCommand extends AutoCommandAbstract {

    public MiddleAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super();
    }

    @Override
    protected void left() {
    	return;
    }
    @Override
    protected void right() {
    	return;
    }

    // Called repeatedly when this Command is scheduled to run

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
