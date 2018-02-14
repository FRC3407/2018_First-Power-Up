package org.usfirst.frc.team3407.robot;

import edu.wpi.first.networktables.NetworkTableInstance;

public class WeekZeroGameInfo extends GameInfo {

	@Override
	protected String getMessage() {
		NetworkTableInstance offSeasonNetworkTable = NetworkTableInstance.create();
		offSeasonNetworkTable.startClient("10.0.100.5");
		String gameData = offSeasonNetworkTable.getTable("OffseasonFMSInfo").getEntry("GameData").getString("defaultValue");
		
		return gameData;
	}

}
