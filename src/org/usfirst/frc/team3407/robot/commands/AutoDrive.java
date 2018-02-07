package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3407.robot.Robot;

/**
 *
 */
public class AutoDrive extends Command {

    public AutoDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	requires(Robot.ultraSonic);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.tank(.5, .5);
    	System.out.println("exec");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.ultraSonic.getDistance()<12)
    		return true;
    	else
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    	System.out.println("end");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    }
}