package org.usfirst.frc.team3407.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3407.robot.RobotMap;

/**
 *
 */
public class Lifter extends Subsystem {
	public static DigitalInput lim= new DigitalInput(RobotMap.LIMIT_SWITCH);
	Counter counter = new Counter(lim);
	private static Victor lifter = new Victor(RobotMap.LIFTER_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void moveDown() {
		// TODO Auto-generated method stub
		if (lifter.get() != 1.0) {
			System.out.println("Lifter speed set to -1");
		}
		lifter.set(1.0);
		
	}
	
	public void moveUp() {
		if (lifter.get() != -1.0) {
			System.out.println("Lifter speed set to 1");
		}
		lifter.set(-1.0);
		
	}
	public void stop() {
		System.out.println("Lifter motor stopped");
		lifter.stopMotor();
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public boolean isSwitch() {
    	return !lim.get();
    }
}

