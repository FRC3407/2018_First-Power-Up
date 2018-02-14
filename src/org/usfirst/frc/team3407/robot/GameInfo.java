package org.usfirst.frc.team3407.robot;

public abstract class GameInfo {
	protected abstract String getMessage();
	public boolean isSwitchLeft() {
		
		return getMessage() != null && getMessage().length() > 0 ?  getMessage().charAt(0) == 'L' : false;
	}
}
