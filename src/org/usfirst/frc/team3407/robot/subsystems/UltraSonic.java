package org.usfirst.frc.team3407.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UltraSonic extends Subsystem {
	AnalogInput ultraSonic = new AnalogInput(3);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getDistance() {
    	
    	return ultraSonic.getVoltage();
    }
}

