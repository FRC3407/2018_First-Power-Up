package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
	//private Victor arms = new Victor(RobotMap.ARMS_MOTOR);
	private DoubleSolenoid dSol = new DoubleSolenoid(RobotMap.DOUBLE_SOLENOID_P1,RobotMap.DOUBLE_SOLENOID_P2);

	public void open() {
		//arms.set(.75);
		dSol.set(DoubleSolenoid.Value.kForward);
	}
	public void close() {
		//arms.set(0);
		dSol.set(DoubleSolenoid.Value.kReverse);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

