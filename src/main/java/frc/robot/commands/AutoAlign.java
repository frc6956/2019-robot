/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoAlign extends Command {
	public AutoAlign() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
  public void execute() {
    if(Robot.lineSensors.getIsLeft()) {
      Robot.drivetrain.setTankDrive(0.5, -0.5);
    }
    if(Robot.lineSensors.getIsRight()) {
      Robot.drivetrain.setTankDrive(-0.5, 0.5);
    }
    if(Robot.lineSensors.getIsOnTarget()) {
      Robot.drivetrain.setTankDrive(0, 0);
    }
    if(Robot.lineSensors.notOnTarget()) {
      Robot.drivetrain.setTankDrive(0, 0);
    }
  }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.setTankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}
