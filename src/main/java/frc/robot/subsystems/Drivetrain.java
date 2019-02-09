/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.commands.TeleopDrive;

/**
 * Drivetrain
 */
public abstract class Drivetrain extends Subsystem {
  private final double speedLimit = 0.8;

  protected DifferentialDrive m_drive;

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
  protected abstract double getRawDistanceTravelled();

}
