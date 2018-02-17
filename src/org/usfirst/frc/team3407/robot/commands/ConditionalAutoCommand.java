package org.usfirst.frc.team3407.robot.commands;

import org.usfirst.frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class ConditionalAutoCommand extends ConditionalCommand {

    public ConditionalAutoCommand(Command leftCommand, Command rightCommand) {
    	super(leftCommand, rightCommand);
    	requires(Robot.drive);
    	requires(Robot.lift);
    	requires(Robot.arms);
    }
     
    @Override
	protected boolean condition() {
		return Robot.weekZeroGameInfo.isSwitchLeft();
	}
}
