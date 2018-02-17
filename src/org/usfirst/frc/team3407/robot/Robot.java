/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot;

import edu.wpi.cscore.VideoCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.HashMap;

//import org.usfirst.frc.team3407.robot.commands.LeftAutoCommand;
import org.usfirst.frc.team3407.robot.commands.LeftPositionAutoCommandBuilder;
import org.usfirst.frc.team3407.robot.commands.MiddlePositionAutoCommandBuilder;
import org.usfirst.frc.team3407.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Pneumatics pneumatics = new Pneumatics();;
	public static final DriveSubsystem drive = new DriveSubsystem();
	//public static final Compressor c = new Compressor();
	public static final UltraSonic ultraSonic = new UltraSonic();
	public static Lifter lift = new Lifter();
	public static Arms arms = new Arms();
	public static OI m_oi;
	public static CameraServo cameraServo;
	//public static GameInfo gameInfo = new CompetitionGameInfo();
	public static GameInfo gameInfo = new WeekZeroGameInfo();

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	private static final String SD_AUTO_CHOOSER_KEY = "Auto mode";
	private static final String SD_AUTO_CHOOSER_SELECTED_KEY = SD_AUTO_CHOOSER_KEY + "/selected";
	private static final String SD_AUTO_INPUT_KEY = "Auto Selector";

	private static HashMap<String,Command> AUTONOMOUS_COMMANDS = new HashMap<>();
	private static String defaultCommandSelect = "";

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		pneumatics = new Pneumatics();
		cameraServo = new CameraServo();
		m_oi = new OI();
		
		addAutoCommand("Left", new LeftPositionAutoCommandBuilder().build(), true);
		addAutoCommand("Middle", new MiddlePositionAutoCommandBuilder().build(), false);
		SmartDashboard.putData(SD_AUTO_CHOOSER_KEY, m_chooser);
		
		SmartDashboard.putNumber("Ultra-Sonic", ultraSonic.getDistance());
		
		VideoCamera camera = CameraServer.getInstance().startAutomaticCapture();
		//HD Resolution
		//camera.setResolution(1280, 720);
		//SD Resolution
		camera.setResolution(640, 480);
		
		System.out.println("Robot Init exec: Switch left=" + gameInfo.isSwitchLeft());
		SmartDashboard.putBoolean("switch position", gameInfo.isSwitchLeft());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = getSelectedAutoCommand();

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			System.out.println("autocomamnd: " + m_autonomousCommand.getName() + " type=" + m_autonomousCommand.getClass().getName());
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Ultra-Sonic", ultraSonic.getDistance());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		//turns off compressor
		//c.setClosedLoopControl(false);
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	 public void teleopPeriodic() {
		SmartDashboard.putNumber("Ultra-Sonic", ultraSonic.getDistance());
    	//System.out.println("TELOP " + ultraSonic.getDistance());
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
	@Override
    public void testPeriodic() {
    	//System.out.println("TEST " + ultraSonic.getDistance());
    }
	
	private void addAutoCommand(String select, Command command, boolean defaultCommand) {
		if (defaultCommand) {
			m_chooser.addDefault(select, command);
			defaultCommandSelect = select;
		} else {
			m_chooser.addObject(select, command);	
		}
		AUTONOMOUS_COMMANDS.put(select, command);
	}
	
	public Command getSelectedAutoCommand() {
		Command command = null;
		
		String chooserSelection = SmartDashboard.getString(SD_AUTO_CHOOSER_SELECTED_KEY, "");
		System.out.println("ChooserSelection= " + chooserSelection);
		if ((chooserSelection == null) || chooserSelection.isEmpty() || !AUTONOMOUS_COMMANDS.containsKey(chooserSelection)) {
			// Try using input field 
			String inputSelection = SmartDashboard.getString(SD_AUTO_INPUT_KEY, "XYZ");
			//inputSelection = SmartDashboard.getString("DB/String 0", "ABC");
			System.out.println("InputSelection= " + inputSelection);
			command = AUTONOMOUS_COMMANDS.get(inputSelection);			
		}
		else {
			System.out.println("Command from chooser");
			command = m_chooser.getSelected();
		}
	
		if (command == null) {
			System.out.println("Using default command: " + defaultCommandSelect);
			command = AUTONOMOUS_COMMANDS.get(defaultCommandSelect);
		}
		
		return command;
	}


}
