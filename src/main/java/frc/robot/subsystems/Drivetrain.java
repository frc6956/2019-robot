/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopDrive;

/**
 * Drivetrain
 */
public class Drivetrain extends Subsystem {
  private final double ticksPerInch = 4096 / (6 * Math.PI);
  private final double speedLimit = 1.0;
  private DifferentialDrive m_drive;
  private WPI_TalonSRX m_leftSRX;
  private WPI_TalonSRX m_rightSRX;

  public Drivetrain() {
    m_leftSRX = new WPI_TalonSRX(RobotMap.leftDriveMotor);
    WPI_VictorSPX m_leftSPX1 = new WPI_VictorSPX(RobotMap.leftDriveSPX1);
    WPI_VictorSPX m_leftSPX2 = new WPI_VictorSPX(RobotMap.leftDriveSPX2);
    
    m_rightSRX = new WPI_TalonSRX(RobotMap.rightDriveMotor);
    WPI_VictorSPX m_rightSPX1 = new WPI_VictorSPX(RobotMap.rightDriveSPX1);
    WPI_VictorSPX m_rightSPX2 = new WPI_VictorSPX(RobotMap.rightDriveSPX2);
    
    m_drive = new DifferentialDrive(m_leftSRX, m_rightSRX);
    m_leftSPX1.follow(m_leftSRX);
    m_leftSPX2.follow(m_leftSRX);
    m_rightSPX1.follow(m_rightSRX);
    m_rightSPX2.follow(m_rightSRX);

    m_leftSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    m_leftSRX.setSensorPhase(true);
    m_rightSRX.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

  }

  private double zeroDistance = 0;
  private boolean reverse = false;

  @Override
  /**
   * What the robot does on default
   */
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDrive());
  }
  

  /**
   * Sets Tank Drive and Speed
   */
  public void setTankDrive(double left, double right) {
    if (reverse) {
      m_drive.tankDrive(-right * speedLimit, -left * speedLimit);
    } else {
      m_drive.tankDrive(left * speedLimit, right * speedLimit);
    }
  }

  /**
   * Sets Arcade Drive speed and rotation
   * @param speed
   * @param rotation
   */
  public void setArcadeDrive(double speed, double rotation) {
    rotation = rotation * speedLimit;
    if (reverse) {
      speed = -speed * speedLimit;
    } else {
      speed = speed * speedLimit;
    }
    SmartDashboard.putNumber("speed", speed);
    SmartDashboard.putNumber("rotation", rotation);
    m_drive.arcadeDrive(speed, rotation);
  }

  /**
   * Gets the distance travelled 
   */
  public double getDistanceTravelled() {
    return getRawDistanceTravelled() - zeroDistance;
  }

  /**
   * Resets the distance travelled
   */
  public void resetDistanceTravelled() {
    zeroDistance = getRawDistanceTravelled();
  }

  /**
   * Reverses the drivetrain
   * @param reverse
   */
  public void reverse(boolean reverse) {
    this.reverse = reverse;
  }

  /**
   * Checks if the drivetrain is reversed
   * @return
   */
  public boolean isReversed() {
    return reverse;
  }

  /**
   * gets the total distance travelled
   * @return
   */
  protected double getRawDistanceTravelled() {
    double total = m_leftSRX.getSelectedSensorPosition(0) / ticksPerInch;
    total += m_rightSRX.getSelectedSensorPosition(0) / ticksPerInch;
    return (total / 2);
  }
}
