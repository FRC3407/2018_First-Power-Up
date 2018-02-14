package org.usfirst.frc.team3407.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class CompetitionGameInfo extends GameInfo {

	@Override
	protected String getMessage() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}

}
