/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TeleopDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double speedLimit = 1.0;

//Put Motors Here
  
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

public void setSplitArcade(double yThrottle, double rotate) {
  m_drive.splitArcade(yThrottle * speedLimit, rotate * speedLimit);
}


}
