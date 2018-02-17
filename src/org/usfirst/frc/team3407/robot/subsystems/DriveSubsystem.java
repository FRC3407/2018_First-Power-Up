/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.RobotMap;
import org.usfirst.frc.team3407.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;


public class DriveSubsystem extends Subsystem {	
	
	private static double SCALE = 0.7;
	
	private Victor 	m_FrontLeft = new Victor(RobotMap.FRONT_LEFT_MOTOR);
	Victor m_BackLeft = new Victor(RobotMap.BACK_LEFT_MOTOR) ;
	SpeedControllerGroup m_left = new SpeedControllerGroup(m_FrontLeft, m_BackLeft);
	
	Victor m_FrontRight = new Victor(RobotMap.FRONT_RIGHT_MOTOR);
	Victor m_BackRight = new Victor(RobotMap.BACK_RIGHT_MOTOR);
	SpeedControllerGroup m_right = new SpeedControllerGroup(m_FrontRight, m_BackRight);
	
	DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);
	
	public void tank(double leftPow, double rightPow) {
		m_drive.tankDrive(leftPow*SCALE , rightPow*SCALE);
	}
	public void initDefaultCommand() {
	setDefaultCommand(new DriveCommand());
	}
	public void timedDrive(double timeout, double leftPow, double rightPow) {
		m_drive.tankDrive(leftPow , rightPow);
		Timer.delay(timeout);
		stop(); 	 
	}
	public void stop() {
		m_drive.tankDrive(0, 0);
	}
	
	
	
}
