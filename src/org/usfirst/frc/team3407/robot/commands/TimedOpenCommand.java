package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedOpenCommand extends TimedCommand {

    public TimedOpenCommand(double timeout) {
        super(timeout);
    	requires(Robot.arms);	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arms.open();
    }

    // Called once after timeout
    protected void end() {
    	Robot.arms.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
       	Robot.arms.close();
    }
}
