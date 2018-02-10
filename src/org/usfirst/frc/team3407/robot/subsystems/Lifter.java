package org.usfirst.frc.team3407.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3407.robot.RobotMap;

/**
 *
 */
public class Lifter extends Subsystem {

	private static Victor lifter = new Victor(RobotMap.LIFTER_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void move(boolean up) {
		if(up) {
			lifter.set(.75);
		} else {
			lifter.set(-.5);
		}
	}
	public void stop() {
		lifter.stopMotor();
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

