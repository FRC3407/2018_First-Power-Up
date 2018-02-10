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
	public static final int BACK_RIGHT_MOTOR = 3;
	public static final int FRONT_RIGHT_MOTOR = 0;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int BACK_LEFT_MOTOR = 2;
	public static final int CAMERA_SERVO = 8;
	 
	//Solenoids
	public static final int SOLENOID = 0;
	 
	//Joysticks
	public static final int STICK_L = 0;
	public static final int STICK_R = 1;
	public static final int STICK_CAMERA = 2;
	
	//Buttons
	public static final int SOLENOID_TRIGGER = 1;//STICK_R
	public static final int RESET_TRIGGER = 1;//STICK_CAMERA
	
	//Sensors
	public static final int ULTRASONIC = 3;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
