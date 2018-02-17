package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Solenoid sol = null; //new Solenoid(RobotMap.SOLENOID);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    //Aaron Wuz Here
    public void shoot() {
    	sol.set(true);
    	Timer.delay(0.1);
    	sol.set(false);
    }
    
    public void stop(){
    	sol.set(false);
    }
}
