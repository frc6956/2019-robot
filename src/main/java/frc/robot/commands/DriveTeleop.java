/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;


public class DriveTeleop extends Command {
  public DriveTeleop() {
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
  protected void execute() {
    if(!Robot.m_oi.getIsJoystick())
    {
    if(Robot.m_oi.getIsTank())
    {
      Robot.drivetrain.setTankDrive(Robot.m_oi.getTankLeft(), Robot.m_oi.getTankRight()); // tank
    }
    else
    {
      Robot.drivetrain.setArcadeDrive(Robot.m_oi.getArcadeY(), Robot.m_oi.getArcadeX()); // arcade
    }
   }
   else
   {
    if(Robot.m_oi.getIsTank())
    {
      Robot.drivetrain.setTankDrive(Robot.m_oi.getTankLeft(), Robot.m_oi.getTankRight());
    }
    else
    {
      Robot.drivetrain.setArcadeDrive(Robot.m_oi.getArcadeY(), Robot.m_oi.getArcadeX());
    }
   }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
