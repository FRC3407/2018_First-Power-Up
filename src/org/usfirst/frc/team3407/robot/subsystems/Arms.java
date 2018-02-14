package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
	public static Victor arms = new Victor(RobotMap.ARMS_MOTOR);

	public void open() {
		arms.set(.75);
	}
	public void close() {
		arms.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

