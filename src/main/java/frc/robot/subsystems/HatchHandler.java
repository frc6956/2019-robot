/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Controls the hatch system for the robot
 */
public class HatchHandler extends Subsystem {
  DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.doubleSolenoidA, RobotMap.doubleSolenoidB);
	private int times_used = 0;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
  }

  /**
   * Pushes out the Hatch
   */
  public void open() {
    if (doubleSolenoid.get() != DoubleSolenoid.Value.kReverse) {
			doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
			times_used++;
			SmartDashboard.putNumber("Times Opened", times_used);
			SmartDashboard.putString("Grabber State", "Open");
		}
  }

  /**
   * Brings the Pneumatics back in
   */
  public void close() {
    if (doubleSolenoid.get() != DoubleSolenoid.Value.kForward) {
			doubleSolenoid.set(DoubleSolenoid.Value.kForward);
			SmartDashboard.putString("Grabber State", "Closed");
		}
  }
  
}
