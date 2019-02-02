/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMapTempest;

/**
 * Drivetrain implementation for Tempest (2018)
 */
public class DrivetrainTempest extends Drivetrain {
  // calculate ticsPerInch
  private final double ticksPerInch = 4096 / (4 * Math.PI);

  private WPI_TalonSRX m_leftSRX;
  private WPI_VictorSPX m_leftSPX;
  private SpeedController m_left;

  private WPI_TalonSRX m_rightSRX;
  private WPI_VictorSPX m_rightSPX;
  private SpeedController m_right;

  public DrivetrainTempest() {
    m_leftSRX = new WPI_TalonSRX(RobotMapTempest.leftDriveMotor);
    m_leftSPX = new WPI_VictorSPX(RobotMapTempest.leftDriveMotor2);
    m_left = new SpeedControllerGroup(m_leftSRX, m_leftSPX);

    m_rightSRX = new WPI_TalonSRX(RobotMapTempest.rightDriveMotor);
    m_rightSPX = new WPI_VictorSPX(RobotMapTempest.rightDriveMotor2);
    m_right = new SpeedControllerGroup(m_rightSRX, m_rightSPX);

    m_drive = new DifferentialDrive(m_left, m_right);
  }

  protected double getRawDistanceTravelled() {
    double total = m_leftSRX.getSelectedSensorPosition(0) / ticksPerInch;
    total += m_rightSRX.getSelectedSensorPosition(0) / ticksPerInch;
    return (total / 2);
  }
}
