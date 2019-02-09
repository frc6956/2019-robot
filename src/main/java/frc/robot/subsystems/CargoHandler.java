/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopCargo;

/**
 * Interface to the cargo handler
 */
public class CargoHandler extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Talon wheels = new Talon(RobotMap.cargoHandlerWheels);
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopCargo());
  }
  public void setWheelsSpeed(double speed) {
    wheels.setSpeed(speed);
  }
}
