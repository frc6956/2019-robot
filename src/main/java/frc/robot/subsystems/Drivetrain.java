/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private double speedLimit = 0.8;
  VictorSP m_leftSP = new VictorSP(RobotMap.leftDriveMotor);
  SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftSP);

  VictorSP m_rightSP = new VictorSP(RobotMap.rightDriveMotor);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightSP);

  DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  public Drivetrain() {
  }
  // Put methods for controlling this subsystem/
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new TeleopDrive());
  }

  public void setTankDrive(double left_Power, double right_Power) {
    m_drive.tankDrive(left_Power * speedLimit, right_Power * speedLimit);
  }

  public void setArcadeDrive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed * speedLimit, zRotation * speedLimit);
  }

}
