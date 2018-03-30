package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {

    public TestAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//addSequential(new TimedDrive(3,.6,.6));
    	addSequential(new TimedDrive(6, .6, .6));

    	
    	//turning data 
    	
    	//TODO: Check for 45 degree angle 
    	//until done, go .47 for .5 seconds
    	
    	//1 second, .47 is 90 degrees, stacks to more seconds (2 second .47 = 180)
    	//1 second, .55 is 180 degrees, stacks
    	//1 second, .6 is 270, almost stacks (add a very small amount as fudge factor)
    	
    	//driving data
    	
    	//1 second .6 = 9 feet 
    	//2 seconds .6 = 5 feet more
    	//3 seconds .6 = 4.5 feet more
    	//4 seconds .6 = 3.5 feet more 
    	//5 seconds .6 = 3.3 feet more
    	//6 seconds .6 = 5.7 more???? idk. we hopefully will never go that long. 
    	
    	//1 second .5 = 4.5 feet
    	//2 second .5 = 2.75 feet more
    	//3 second .5 = 2.25 feet more
    	
    }
}
