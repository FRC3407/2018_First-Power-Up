/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot;

import java.net.InetAddress;
import java.net.NetworkInterface;

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
	
	
	//Sensors
	public static final int ULTRASONIC = 3;
	
	private static byte[] mac;
	
	static {
		try {
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			mac = network.getHardwareAddress();

			System.out.print("Current MAC address : ");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Is Haugbui: " + RobotName.HAUGBUI.isMatch(mac));
	}

	public enum RobotName { 
		LAMBDA_CHOPS(null), 
		HAUGBUI(new int[] { 0x00, 0x80, 0x2F, 0x17, 0xC3, 0x48 });
		
		private int[] mac;
		private RobotName(int[] mac) {
			this.mac = mac;
		}
		
		private boolean isMatch(byte[] mac) {
			boolean match = true;
			for(int i = 0;i < 6;i++) {
				if (this.mac[i] != (((int) mac[i]) & ((int) 0xFF))) {
					match = false;
					break;					
				}
			
			}
			
			return match;
		}
		
	};
	
	public static boolean hasCameras() {
		return !RobotName.HAUGBUI.isMatch(mac);
	}

	public static boolean hasArms() {
		return !RobotName.HAUGBUI.isMatch(mac);
	}
	
	public static boolean hasLifter() {
		return !RobotName.HAUGBUI.isMatch(mac);
	}	
}
