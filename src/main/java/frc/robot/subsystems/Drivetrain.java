/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.commands.*;

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

        public Drivetrain(){}
  // Put methods for controlling this subsystem/
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveTeleop());
  }

  public void setTankDrive(double left_Power, double right_Power)
  {
    m_drive.tankDrive(left_Power*speedLimit, right_Power*speedLimit);
  }
  public void setArcadeDrive(double y_Power, double x_Power)
  {
    m_drive.arcadeDrive(y_Power*speedLimit, x_Power*speedLimit); // arcade
  }
}
