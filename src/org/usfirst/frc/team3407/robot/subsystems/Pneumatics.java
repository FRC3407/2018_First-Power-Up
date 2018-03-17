package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid dSol = new DoubleSolenoid(5,6);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    //Aaron Wuz Here
    public void forward() {
    	dSol.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reverse() {
    	dSol.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void off(){
    	dSol.set(DoubleSolenoid.Value.kOff);
    }
}
