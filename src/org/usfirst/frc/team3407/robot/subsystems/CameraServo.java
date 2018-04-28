package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;
import org.usfirst.frc.team3407.robot.commands.MoveServo;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraServo extends Subsystem {
	Servo camServ = new Servo(RobotMap.CAMERA_SERVO);
	double lastPos = 0.0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveServo());
    }
    
    public void move(double pos) {
    	if(Math.abs(pos-lastPos)>0.1) {
    		System.out.println("diff: " + Math.abs(pos-lastPos));
    		camServ.set(pos);
    	}else {
    		camServ.set(lastPos);
    		System.out.println("last");
    	}
    	//System.out.println("move: "+pos);
    }
    
    public void reset() {
    	camServ.set(0.5);
    }
}

