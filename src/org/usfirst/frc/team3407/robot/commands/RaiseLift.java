package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseLift extends Command {

    public RaiseLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		System.out.println("RaiseLift Executing");
    	Robot.lift.move(true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// Return false so button control works
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
		System.out.println("RaiseLift Ended");
    	Robot.lift.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
		System.out.println("RaiseLift Interupted");
    	Robot.lift.stop();
    }
}
