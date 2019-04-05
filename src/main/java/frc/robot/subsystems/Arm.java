/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TeleopArm;

/**
 * Arm for the CargoHandler
 */
public class Arm extends Subsystem {
  public static final double floorLevel = 1.0;
  public static final double upLevel = 3.0;
  public static final double rocketLevel1 = 2.0;

  private static final double allowedError = 0.1;
  private static final double minAutoSpeed = 0.1;
  private static final double maxAutoSpeed = 1.0;
  private static final double kP = 1.0;

  private double targetPosition;
  private Talon motor = new Talon(RobotMap.cargoHandlerArm);
  private AnalogInput stringPot = new AnalogInput(RobotMap.stringPot);

  /**
   * What the arm does by default
   */
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TeleopArm());
  }

  /**
   * Sets the speed of the arm
   * @param speed Arm speed
   */
  public void setArmSpeed(double speed) {
    motor.setSpeed(speed);
  }

  /**
   * Returns the position of the arm
   * @return Position of the arm
   */
  public double getPosition() {
    return stringPot.getVoltage();
  }

  /**
   * Sets the current target position
   * @param target Target position
   */
  public void setTargetPosition(double target) {
    targetPosition = target;
  }

  /**
   * Automatically moves arm to the target position
   */
  public void goToTarget() {
    double speed = 0.0;
    double error = getPosition() - targetPosition;

    if(Math.abs(error) > allowedError) {
      speed = Math.abs(error) * kP;
      speed = Math.max(minAutoSpeed, speed);
      speed = Math.min(maxAutoSpeed, speed);
      speed = Math.copySign(speed, error);
    }

    setArmSpeed(speed);
  }
}
