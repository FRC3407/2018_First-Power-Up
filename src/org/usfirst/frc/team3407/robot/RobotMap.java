/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	
	//Actuators
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int BACK_RIGHT_MOTOR = 3;
	public static final int FRONT_LEFT_MOTOR = 0;
	public static final int BACK_LEFT_MOTOR = 1;
	public static final int CAMERA_SERVO = 8;
	public static final int LIFTER_MOTOR = 5;
	public static final int ARMS_MOTOR = 6;
	 
	//Solenoids
	public static final int DOUBLE_SOLENOID_P1 = 0;
	public static final int DOUBLE_SOLENOID_P2 = 1;
	 
	//Joysticks
	public static final int STICK_L = 0;
	public static final int STICK_R = 1;
	public static final int STICK_CAMERA = 2;
	
	//Buttons
	public static final int RESET_TRIGGER = 1;//STICK_CAMERA
	public static final int LIFT_TRIGGER_DOWN = 2;
	public static final int LIFT_TRIGGER_UP = 3;
	public static final int ARMS_TRIGGER = 1;
	
	//cameras
	public static final int FIXED_CAM = 0;
	public static final int SERVO_CAM = 1;
	
	
	//Sensors
	public static final int ULTRASONIC = 3;
	public static final int LIMIT_SWITCH = 0;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
