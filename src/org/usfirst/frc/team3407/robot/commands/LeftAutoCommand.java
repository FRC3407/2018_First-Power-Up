package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.Timer;


/**
 *
 */
public class LeftAutoCommand extends AutoCommandAbstract {
    public LeftAutoCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super();
    }

    // Called just before this Command runs the first times
    @Override
    protected void left() {
    	Timer.delay(3);
    	Robot.drive.timedDrive(1, .7, .7);
    	Robot.lift.move(false);
    	Timer.delay(2);
    	Robot.lift.stop();
    	Robot.arms.open();
    	Timer.delay(1);
    	Robot.arms.close();
    }
    @Override
    protected void right() {
    	return;
    }
    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
