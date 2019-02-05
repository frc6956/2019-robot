/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.TeleopDrive;

/**
 * Add your docs here.
 */
public abstract class Drivetrain extends Subsystem {
  private final double speedLimit = 0.8;

  protected DifferentialDrive m_drive;

  private double zeroDistance = 0;
  private boolean reverse = false;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopDrive());
  }

  public void setTankDrive(double left, double right) {
    if (reverse) {
      m_drive.tankDrive(-right * speedLimit, -left * speedLimit);
    } else {
      m_drive.tankDrive(left * speedLimit, right * speedLimit);
    }
  }

  public void setArcadeDrive(double speed, double rotation) {
    if (reverse) {
      m_drive.arcadeDrive(-speed * speedLimit, rotation * speedLimit);
    } else {
      m_drive.arcadeDrive(speed * speedLimit, rotation * speedLimit);
    }
  }

  public double getDistanceTravelled() {
    return getRawDistanceTravelled() - zeroDistance;
  }

  public void resetDistanceTravelled() {
    zeroDistance = getRawDistanceTravelled();
  }

  public void reverse(boolean reverse) {
    this.reverse = reverse;
  }

  public boolean isReversed() {
    return reverse;
  }

  public void AutoAlign() {
    if(Robot.lineSensors.getIsLeft()) {
      Robot.drivetrain.setTankDrive(1, -1);
    }
    if(Robot.lineSensors.getIsRight()) {
      Robot.drivetrain.setTankDrive(-1, 1);
    }
    if(Robot.lineSensors.getIsOnTarget()) {
      Robot.drivetrain.setTankDrive(0, 0);
    }
    if(Robot.lineSensors.notOnTarget()) {
      Robot.drivetrain.setTankDrive(0, 0);
    }
  }
  protected abstract double getRawDistanceTravelled();

}
