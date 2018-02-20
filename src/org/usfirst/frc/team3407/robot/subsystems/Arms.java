package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
	//private Victor arms = new Victor(RobotMap.ARMS_MOTOR);
	private Solenoid solenoid = new Solenoid(RobotMap.SOLENOID);

	public void open() {
		//arms.set(.75);
		solenoid.set(true);
	}
	public void close() {
		//arms.set(0);
		solenoid.set(false);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

