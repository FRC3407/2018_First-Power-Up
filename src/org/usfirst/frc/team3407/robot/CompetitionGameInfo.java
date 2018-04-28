package org.usfirst.frc.team3407.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class CompetitionGameInfo extends GameInfo {

	@Override
	protected String getMessage() {
		String message = DriverStation.getInstance().getGameSpecificMessage();
		System.out.println("GSM: " + message);
		return message;
	}

}
