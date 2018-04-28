package org.usfirst.frc.team3407.robot;

public abstract class GameInfo {
	protected abstract String getMessage();
	public boolean isSwitchLeft() {
		
		return getMessage() != null && getMessage().length() > 0 ?  getMessage().charAt(0) == 'L' : false;
	}
public boolean isValid() {
		
		//return getMessage() != null && getMessage().length() > 0 ?  (getMessage().charAt(0) == 'L' || !(getMessage().charAt(0) == 'R')) : false;
		if(getMessage() != null) {
			System.out.println(" game info is not null");
			if(getMessage().length() >0) {
				System.out.println("game info length is greater than 0");
				if((getMessage().charAt(0) == 'L' || (getMessage().charAt(0) == 'R'))) {
					System.out.println("get message 0 = " + (getMessage().charAt(0)));
					return true;
				}
				System.out.println("get message 0 = " + (getMessage().charAt(0)));
			}
			System.out.println("game info length is 0 or less");
			return false;
		}
		else{
			System.out.println("game info data is null");
			return false;
		}
}

}
