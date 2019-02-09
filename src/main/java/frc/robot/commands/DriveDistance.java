/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
<<<<<<< HEAD
/**
 * 
=======

/**
 * Drives distance in inches. (Note: Robot might drift slightly over the set distance)
>>>>>>> af0a10fe22c6f6a2163651119bb0a5577ed30df4
 */
public class DriveDistance extends Command {

  double desiredDistance;
  double initAngle;

  public DriveDistance(double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    desiredDistance = distance;
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initAngle = Robot.gyro.getAngle();
    Robot.drivetrain.resetDistanceTravelled();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double left = 0.5, right = 0.5;
    double currentAngle = Robot.gyro.getAngle();

    if (currentAngle < initAngle) {
      left += 0.1;
    } else if (currentAngle > initAngle) {
      right += 0.1;
    }
    Robot.drivetrain.setTankDrive(left, right);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.drivetrain.getDistanceTravelled() >= desiredDistance) {
      return true;
    } else {
      return false;
    }
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
