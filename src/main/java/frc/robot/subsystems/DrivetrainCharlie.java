/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMapCharlie;

/**
 * Drivetrain implementation for Charlie (QuickBuild)
 */
public class DrivetrainCharlie extends Drivetrain {
  private final double inchesPerSecond = 12;
  
  private SpeedController m_left;
  private SpeedController m_right;

  public DrivetrainCharlie() {
    m_left = new VictorSP(RobotMapCharlie.leftDriveMotor);
    m_right = new VictorSP(RobotMapCharlie.rightDriveMotor);
    m_drive = new DifferentialDrive(m_left, m_right);
  }

  protected double getRawDistanceTravelled() {
    return Timer.getFPGATimestamp() * inchesPerSecond;
  }
}
