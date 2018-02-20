package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3407.robot.Robot;

/**
 *
 */
public class AutoDrive extends Command {
	
	private static double SCALE = 0.1;
	private static double lim;
    public AutoDrive(double lim) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	requires(Robot.ultraSonic);
    	this.lim = lim;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = (Robot.ultraSonic.getDistance() / 12.0) * SCALE;
    	speed = Math.min(speed, 0.5);
    	speed = Math.max(0.3, speed);
    	//System.out.println("AutoDrive setting speed: " + speed + " at distance " + Robot.ultraSonic.getDistance());
    	Robot.drive.tank(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.ultraSonic.getDistance()<lim) {
    		//System.out.println(Robot.ultraSonic.getDistance());
    		return true;
    	}
    	else {
    		return false;
    	}
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
